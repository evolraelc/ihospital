package com.ihospital.service.impl;

import com.ihospital.mapper.*;
import com.ihospital.pojo.*;
import com.ihospital.service.ITreatService;
import entity.DrugSelect2;
import entity.PatientTreating;
import entity.TreatmentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: ihospital
 * @description: 医生工作功能实现
 * @author: Mr.King
 * @create: 2019-11-26 20:53
 **/


@Service
@Transactional
public class TreatService implements ITreatService {

    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private AppointmentMapper appointmentMapper;
    @Autowired
    private PathographyMapper pathographyMapper;
    @Autowired
    private MedicineMapper medicineMapper;
    @Autowired
    private PrescriptionMapper prescriptionMapper;


    @Override
    public PatientTreating getNextPatient(Date date, Long deptId) {

        PatientTreating patientTreating = getPatients(date, deptId).get(0);
        patientTreating.getAppointment().setIsValid(false);
        appointmentMapper.updateByPrimaryKey(patientTreating.getAppointment());
        //提交
        return patientTreating;
    }

    @Override
    public List<PatientTreating> getPatients(Date date, Long deptId) {
        List<PatientTreating> patientTreatings = new ArrayList<>();

        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andDeptIdEqualTo(deptId);
        criteria.andIsValidEqualTo(true);
        criteria.andTreatTimeEqualTo(date);
        appointmentExample.setOrderByClause("`priority` ASC,`appoint_time` ASC");
        List<Appointment> appointments = appointmentMapper.selectByExample(appointmentExample);
        for (int i = 0; i < appointments.size(); i++) {
            PatientTreating patientTreating = new PatientTreating();
            patientTreating.setAppointment(appointments.get(i));
            Patient patient = patientMapper.selectByPrimaryKey(appointments.get(i).getPatientId());
            patientTreating.setPatient(patient);
            patientTreatings.add(i, patientTreating);

        }
        return patientTreatings;
    }

    @Override
    public void addTreatment(TreatmentInfo treatmentInfo) {
        Pathography pathography = treatmentInfo.getPathography();
        pathography.setPathoValid(true);
        pathographyMapper.insert(pathography);
        List<Prescription> prescriptionList = treatmentInfo.getDrugList();
        for (Prescription drug : prescriptionList
        ) {
            drug.setPathoId(pathography.getPathoId());
            Medicine medicine = medicineMapper.selectByPrimaryKey(drug.getMedicineId());
            drug.setPrice(drug.getNum() * medicine.getMedicinePrice());
            prescriptionMapper.insert(drug);
        }


    }

    @Override
    public List<DrugSelect2> findConfigOfDrug() {
        List<DrugSelect2> drugSelect2List = new ArrayList<>();
        List<Medicine> medicineList = medicineMapper.selectByExample(null);
        for (int i = 0; i < medicineList.size(); i++) {
            DrugSelect2 drugSelect2 = new DrugSelect2();
            drugSelect2List.add(i, drugSelect2);
            //设置ID
            drugSelect2List.get(i).setId(medicineList.get(i).getMedicineId());
            //设置text
            drugSelect2List.get(i).setText(medicineList.get(i).getMedicineName());

        }
        return drugSelect2List;
    }

    @Override
    public Integer getPrice(Long id) {
        return medicineMapper.selectByPrimaryKey(id).getMedicinePrice();
    }

    @Override
    public Integer addAppointment(Appointment appointment) {
        appointment.setIsValid(true);
        appointmentMapper.insert(appointment);
        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andDeptIdEqualTo(appointment.getDeptId());
        criteria.andIsValidEqualTo(true);
        criteria.andTreatTimeEqualTo(appointment.getTreatTime());
        appointmentExample.setOrderByClause("`priority` ASC,`appoint_time` ASC");
        List<Appointment> appointments = appointmentMapper.selectByExample(appointmentExample);
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getAppointmentId().equals(appointment.getAppointmentId())){
                return i+1;
            }

        }

        return 0;

    }


}
