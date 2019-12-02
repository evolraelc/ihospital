package entity;

import com.ihospital.pojo.Pathography;
import com.ihospital.pojo.Prescription;

import java.io.Serializable;
import java.util.List;

/**
 * @program: ihospital
 * @description: 治疗组合实体
 * @author: Mr.King
 * @create: 2019-11-27 13:46
 **/

public class TreatmentInfo implements Serializable {

    private Pathography pathography;
    private List<Prescription> drugList;

    public Pathography getPathography() {
        return pathography;
    }

    public void setPathography(Pathography pathography) {
        this.pathography = pathography;
    }

    public List<Prescription> getDrugList() {
        return drugList;
    }

    public void setDrugList(List<Prescription> drugList) {
        this.drugList = drugList;
    }
}
