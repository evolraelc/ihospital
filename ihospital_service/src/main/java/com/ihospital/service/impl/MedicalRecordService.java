package com.ihospital.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.text.SimpleDateFormat;
import com.ihospital.mapper.*;
import com.ihospital.pojo.*;
import com.ihospital.service.IMedicalRecordService;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author RUANBY
 * @date 2019/11/20 13:16
 */

@Service
@Transactional
public class MedicalRecordService implements IMedicalRecordService {

    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private PhysicianMapper physicianMapper;
    @Autowired
    private PathographyMapper pathographyMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private MedicineMapper medicineMapper;
    @Autowired
    private PrescriptionMapper prescriptionMapper;
    @Autowired
    private AppointmentMapper appointmentMapper;
    /**
     * @author ruanby
     * @date
     * @return
     * @function 根据ID返回病人实体
     */
    @Override
    public Patient findOnePatient(Long id) {
        return patientMapper.selectByPrimaryKey(id);
    }
    //根据ID返回医生实体
    @Override
    public Physician findOnePhysician(Long id) {
        return physicianMapper.selectByPrimaryKey(id);
    }

    //根据医生的ID查科室名字
    @Override
    public String findDeptNameById(Long id) {
        String departmentName=physicianMapper.selectByPrimaryKey(id).getDepartName();
        return departmentName;
    }
    //查找所有的就诊记录
    @Override
    public List<Pathography> findAllPathography() {
        return pathographyMapper.selectByExample(null);
    }
    //根据Id查找一条对应的就诊记录
    @Override
    public Pathography findOnePathographyById(Long id){
        return pathographyMapper.selectByPrimaryKey(id);
    }
    //提取出需要多次调用的代码，返回就诊记录详细信息
    @Override
    public List<MedicalRecord> findAll(List<Pathography> pathographies){
        //就诊信息的总条数
        Integer sumItems= pathographies.size();
        //创建DTO链表，用于返回给展示层
        List<MedicalRecord> mrs=new ArrayList<>();

        for(int i=0;i<sumItems;i++)
        {
            mrs.add(i,new MedicalRecord());
            //设置病人ID
            Long patientId=pathographies.get(i).getPatientId();
            mrs.get(i).setPatientId(patientId);
            //设置病人姓名
            String patientName=findOnePatient(mrs.get(i).getPatientId()).getPatientName();
            mrs.get(i).setPatientName(patientName);
            //设置医生ID
            Long physicianId=pathographies.get(i).getPhysicianId();
            mrs.get(i).setPhysicianId(physicianId);
            //设置医生姓名
            String physicianName=findOnePhysician(mrs.get(i).getPhysicianId()).getPhysicianName();
            mrs.get(i).setPhysicianName(physicianName);
            //设置就诊信息ID
            Long PathoId=pathographies.get(i).getPathoId();
            mrs.get(i).setPathoId(PathoId);
            //设置挂号单ID
            Long AppointmentId=pathographies.get(i).getAppointId();
            mrs.get(i).setAppointmentId(AppointmentId);
            //设置就诊时间
            Date time=pathographies.get(i).getTime();
            mrs.get(i).setTime(time);
            //通过医生ID，设置科室name
            String departName=findDeptNameById(physicianId);
            mrs.get(i).setDepartName(departName);
            //设置有效位
            boolean pathoValid=pathographies.get(i).getPathoValid();
            mrs.get(i).setPathoValid(pathoValid);
            //设置诊断结果
            String diagnosis=pathographies.get(i).getDiagnosis();
            mrs.get(i).setDiagnosis(diagnosis);
            //设置医嘱
            String narrative=pathographies.get(i).getNarrative();
            mrs.get(i).setNarrative(narrative);
        }
        return mrs;
    }

    @Override
    public List<MedicalRecord> findAll() throws Exception {
        return findAll(findAllPathography());
    }

    @Override
    public MedicalRecord findAll(Long id) throws Exception {
        List<Pathography> list=new ArrayList<>();
        list.add(findOnePathographyById(id));
        List<MedicalRecord> mrList=new ArrayList<>();
        mrList=findAll(list);

        return mrList.get(0);
    }

    @Override
    public String findNameByMedicineId(Long id) {
        return medicineMapper.selectByPrimaryKey(id).getMedicineName();
    }

    @Override
    public MedicineInformationResult findMedicineInformationByPathoId(Long id) {
        //根据就诊信息ID得到开的所有药的信息，下一步是将信息中的药ID换成药名
        PrescriptionExample prescriptionExample= new PrescriptionExample();
        PrescriptionExample.Criteria criteria= prescriptionExample.createCriteria();
        criteria.andPathoIdEqualTo(id);
        List<Prescription> prescriptionList=new ArrayList<>();
        prescriptionList=prescriptionMapper.selectByExample(prescriptionExample);
        //开的药品种类数
        Integer sumItems= prescriptionList.size();
        //创建DTO链表，用于返回给展示层
        List<MedicineInformation> medicineInformations=new ArrayList<>();

        for(int i=0;i<sumItems;i++)
        {
            medicineInformations.add(i,new MedicineInformation());
            //设置价格
            int price=prescriptionList.get(i).getPrice();
            medicineInformations.get(i).setMedicinePrice(price);
            //设置数量
            int num=prescriptionList.get(i).getNum();
            medicineInformations.get(i).setNum(num);
            //设置药品名
            String patientName=findNameByMedicineId(prescriptionList.get(i).getMedicineId());
            medicineInformations.get(i).setMedicineName(patientName);

        }
        Integer size =medicineInformations.size();
        Integer total=0;
        for(int i=0;i<size;i++)
        {
            total=total+medicineInformations.get(i).getMedicinePrice();
        }

        return new MedicineInformationResult(total,medicineInformations);
    }

    @Override
    public Patient findPatientByPathoId(Long id) {
        //首先根据就诊信息ID获取病人ID
        Long patientId=findOnePathographyById(id).getPatientId();
        //根据patientId获取patient对象
        return patientMapper.selectByPrimaryKey(patientId);
    }

    @Override
    public Appointment findAppointmentByPathoId(Long id) {
        //首先根据就诊信息ID获取挂号单ID
        Long appointId=findOnePathographyById(id).getAppointId();
        //根据appointId获取appointment对象
        return appointmentMapper.selectByPrimaryKey(appointId);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) throws Exception {
        //分页，调用插件
        PageHelper.startPage(pageNum, pageSize);
        Page<Pathography> pageOfpathography = (Page<Pathography>) pathographyMapper.selectByExample(null);
        List listOfPathography=pageOfpathography.getResult();
        List<MedicalRecord> medicalRecords=findAll(listOfPathography);
        return new PageResult(pageOfpathography.getTotal(),medicalRecords );

    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids){
            pathographyMapper .deleteByPrimaryKey(id);
        }
    }


    /**
     * @author ruanby
     * @date 2019/11/21
     * @return
     * @function 根据病人的名字，查询出对应的病人ID链表
     */
    @Override
    public List<Long> findPatientByName(String name) {

        PatientExample patientExample= new PatientExample();

        PatientExample.Criteria criteria= patientExample.createCriteria();
        criteria.andPatientNameLike("%"+name+"%");
        List<Patient> patients=patientMapper.selectByExample(patientExample);
        List<Long> idList = new ArrayList<>();
        for(Integer i=0;i<patients.size();i++){
            idList.add(patients.get(i).getPatientId());
        }

        return idList;
    }


    /**
     * @author ruanby
     * @date  2019/11/21
     * @return
     * @function 根据医生的名字，查询出对应的ID链表
     */
    @Override
    public List<Long> findPhysicianByName(String name) {
        PhysicianExample physicianExample= new PhysicianExample();

        PhysicianExample.Criteria criteria= physicianExample.createCriteria();
        criteria.andPhysicianNameLike("%"+name+"%");
        List<Physician> physicians=physicianMapper.selectByExample(physicianExample);
        List<Long> idList = new ArrayList<>();
        for(Integer i=0;i<physicians.size();i++){
            idList.add(physicians.get(i).getPhysicianId());
        }
        return idList;
    }
    /**
     * @author ruanby
     * @date  2019/11/23
     * @return
     * @function 根据科室的名字，查询出对应的科室ID链表
     */
    @Override
    public List<Long> findDepartmentByName(String name) {
        DepartmentExample departmentExample= new DepartmentExample();

        DepartmentExample.Criteria criteria= departmentExample.createCriteria();
        if(name!=null)
            criteria.andDepartNameLike(name);
        List<Department> departments=departmentMapper.selectByExample(departmentExample);
        List<Long> idList = new ArrayList<>();
        for(Integer i=0;i<departments.size();i++){
            idList.add(departments.get(i).getDepartId());
        }
        return idList;
    }
    /**
     * @author ruanby
     * @date    2019/11/23
     * @return
     * @function
     */
    //根据科室ID，查询到这些科室下的所有医生id
    @Override
    public List<Long> findPhysicianIdByDepart(List<Long> departIds){
        List<Physician> physicians=new ArrayList<>();
        List<Long> physicianIds=new ArrayList<>();
        PhysicianExample physicianExample= new PhysicianExample();

        PhysicianExample.Criteria criteria= physicianExample.createCriteria();
        criteria.andDepartIdIn(departIds);
        physicians=physicianMapper.selectByExample(physicianExample);

        for(int i=0;i<physicians.size();i++){
            physicianIds.add(physicians.get(i).getPhysicianId());
        }
        return physicianIds;
    }
    //条件查询
    //首先：pageHelper不能直接用于自定义类
    //再者：应保证PageHelper.startPage和你用来分页的对象间不存在其他的sql语句！
    // 它只会对靠近的第一个select查询语句进行分页，否则分页执行的将是
    // 两者间的sql语句，这是list无法强制转换成Page的直接原因
    @Override
    public PageResult findPage(PathographySearch pathographySearch, int pageNum, int pageSize) {


        //根据用户输入的姓名，返回对应的IDList，因为有同姓名的人
        List<Long> patientIdList=findPatientByName(pathographySearch.getPatientName());
        List<Long> physicianIdList=findPhysicianByName(pathographySearch.getPhysicianName());
        Long departmentID=pathographySearch.getDepartID();
        List<Long> departmentIdList=new ArrayList<>();
        departmentIdList.add(departmentID);
        List<Long> physicianIdByDepart=findPhysicianIdByDepart(departmentIdList);
        //分页，调用插件
        PageHelper.startPage(pageNum, pageSize);
        PathographyExample pathographyExample =new PathographyExample();
        PathographyExample.Criteria criteria=pathographyExample.createCriteria();

        //不要在 criteria.andXXX()的参数列表里有操作数据库的操作
        if(pathographySearch!=null){
            if(pathographySearch.getPatientName()!=null&&pathographySearch.getPatientName().length()>0){
                criteria.andPatientIdIn(patientIdList);
            }
            if(pathographySearch.getPhysicianName()!=null&&pathographySearch.getPhysicianName().length()>0){
                criteria.andPhysicianIdIn(physicianIdList);
            }
            if(pathographySearch.getDepartID()!=null){

                criteria.andPhysicianIdIn(physicianIdByDepart);
            }
            if(pathographySearch.getTime()!=null){
                //pathographySearch.getTime()获取前端传过来的日期，只精确到天，跟着的getTime会精确到毫秒
                Date minDate = new Date(pathographySearch.getTime().getTime() / 86400000L * 86400000L - 8 * 3600000);
                Date maxDate = new Date(minDate.getTime() + 86399000L);
                criteria.andTimeBetween(minDate, maxDate);
            }

        }

        Page<Pathography> pageOfpathography = (Page<Pathography>) pathographyMapper.selectByExample(pathographyExample);
        List listOfPathography=pageOfpathography.getResult();
        List<MedicalRecord> medicalRecords=findAll(listOfPathography);
        return new PageResult(pageOfpathography.getTotal(),medicalRecords );
    }

    /**
     * @author ruanby
     * @date  11/25
     * @return
     * @function 查询数据库，返回所有科室的ID和name(对应在config中为text）
     */
    @Override
    public List<departSelect2> findConfigOfDepartment() {
        List<Department> departmentList=departmentMapper.selectByExample(null);
        List<departSelect2> departSelect2List=new ArrayList<>();
        for(int i=0;i<departmentList.size();i++){
            departSelect2List.add(i,new departSelect2());
            //设置ID
            departSelect2List.get(i).setId(departmentList.get(i).getDepartId());
            //设置text
            departSelect2List.get(i).setText(departmentList.get(i).getDepartName());
        }
        return departSelect2List;
    }


    /**
    * @description: 查询病人的预约列表
    * @Param: patientId
    * @return: List<AppointInfo>
    * @author: Cheng
    * @created: 2019/12/9/15:38
    **/
    @Override
    public List<AppointInfo> findAppointmentList(Long patientId){

        //初始化列表
        List<AppointInfo> appointInfoList=new ArrayList<>();
        List<Department> departmentsOrderedByPatientId=new ArrayList<>();
//        List<List<Appointment>> appointmentsOrderedByDepartId=new ArrayList<>();

        //存放病人的就诊时间
        List<Integer> treatTime=new ArrayList<>();
        //存放病人的就诊序号
        List<Integer> num=new ArrayList<>();

        //按病人id查询预约表appointments
        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andPatientIdEqualTo(patientId);
        List<Appointment> appointList = appointmentMapper.selectByExample(appointmentExample);

        //将appointments中的科室通过departId筛选出来
        //筛选科室是为了将科室的一些信息也显示出来
        for (Integer i=0;i<appointList.size();i++){
            departmentsOrderedByPatientId.add(departmentMapper.selectByPrimaryKey(appointList.get(i).getDeptId()));
        }


        //将病人在不同科室挂的号分离出来，并将所挂每个科室现存的所有等待病人搜索出来
        //所有数据放入一个List<List<Appointment>>中，每一个List<Appointment>中存放
        //某个科室的所有当前病人列表
        for (Integer i=0;i<departmentsOrderedByPatientId.size();i++){

            //patientId对应病人在所有病人中的物理位置
            Integer patientLocationInList=0;
            //patientId对应病人在所有病人中的等待位置
            Integer patientWaitingNum=0;

            AppointmentExample appointmentExample2 = new AppointmentExample();
            AppointmentExample.Criteria criteria2 = appointmentExample.createCriteria();
            criteria2.andDeptIdEqualTo(departmentsOrderedByPatientId.get(i).getDepartId());
            List<Appointment> partAppointments = appointmentMapper.selectByExample(appointmentExample2);

            //记录patientId在所有病人中的物理顺序,并且将其中一个科室的就诊列表
            //里面的病人的就诊时间转换成Int型数据存入List num里面
            for (Integer j=0;j<partAppointments.size();j++){
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = simpleDateFormat.format(partAppointments.get(j).getTreatTime());
                treatTime.add(j,Integer.parseInt(dateString));

                if(partAppointments.get(j).getPatientId().equals(patientId)) {
                    patientLocationInList=j;
                }
            }

            //计算病人前面还需等待的人数
            for (Integer k=0;k<treatTime.size();k++){
                patientWaitingNum=treatTime.get(patientLocationInList);
                if(treatTime.get(k)<patientWaitingNum) {
                    patientWaitingNum++;
                }
            }
            num.add(i,patientWaitingNum);
//            appointmentsOrderedByDepartId.add(i,partAppointments);
        }


        //将来自不同地方的消息传进appointInfoList里面
        for (Integer i=0;i<appointList.size();i++){
            appointInfoList.add(i,new AppointInfo());

            //从departmentsOrderedByPatientId中获取的数据
            appointInfoList.get(i).setDepartmentName(departmentsOrderedByPatientId.get(i).getDepartName());
            appointInfoList.get(i).setAddress(departmentsOrderedByPatientId.get(i).getPosition());

            //从appointList中获取的数据
            appointInfoList.get(i).setTreatTime(appointList.get(i).getTreatTime());
            appointInfoList.get(i).setAppointTime(appointList.get(i).getAppointTime());
            appointInfoList.get(i).setType(appointList.get(i).getPriority());

            //从list num中获取数据
            appointInfoList.get(i).setNum(num.get(i));
        }

        return appointInfoList;
    }
}
