package com.ihospital.pojo;

import java.io.Serializable;

public class Prescription implements Serializable {
    private Long prescriptId;

    private Long pathoId;

    private Long medicineId;

    public Long getPrescriptId() {
        return prescriptId;
    }

    public void setPrescriptId(Long prescriptId) {
        this.prescriptId = prescriptId;
    }

    public Long getPathoId() {
        return pathoId;
    }

    public void setPathoId(Long pathoId) {
        this.pathoId = pathoId;
    }

    public Long getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Long medicineId) {
        this.medicineId = medicineId;
    }
}