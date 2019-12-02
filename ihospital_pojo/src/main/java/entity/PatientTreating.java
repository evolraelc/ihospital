package entity;

import com.ihospital.pojo.Appointment;
import com.ihospital.pojo.Patient;

import java.io.Serializable;

/**
 * @program: ihospital
 * @description: 治疗中的病人实体
 * @author: Mr.King
 * @create: 2019-11-26 20:40
 **/

public class PatientTreating implements Serializable {
    private Patient patient;
    private Appointment appointment;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "PatientTreating{" +
                "patient=" + patient +
                ", appointment=" + appointment +
                '}';
    }
}
