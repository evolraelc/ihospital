package entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author RUANBY
 * @date 2019/11/21 10:54
 * @description 由于Pathography类中只有医生和病人的ID，没有name,
 *              所以需要这个类作为转换
 */
public class PathographySearch implements Serializable {

    //医生名字
    private String physicianName;

    //就诊时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    //@JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;

    //病人的名字
    private String patientName;

    //科室的ID
    private Long departID;



    public PathographySearch() {
    }

    public PathographySearch(String physicianName, Date time, String patientName, Long departID) {
        this.physicianName = physicianName;
        this.time = time;
        this.patientName = patientName;
        this.departID = departID;
    }

    public Long getDepartID() {
        return departID;
    }

    public void setDepartID(Long departID) {
        this.departID = departID;
    }

    public String getPhysicianName() {
        return physicianName;
    }

    public void setPhysicianName(String physicianName) {
        this.physicianName = physicianName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @Override
    public String toString() {
        return "PathographySearch{" +
                "physicianName='" + physicianName + '\'' +
                ", time=" + time +
                ", patientName='" + patientName + '\'' +
                ", departID=" + departID +
                '}';
    }
}
