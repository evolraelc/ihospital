package entity;

import java.io.Serializable;

/**
 * @author RUANBY
 * @date 2019/11/22 22:43
 */
public class MedicineInformation implements Serializable {
    //药品名
    private String medicineName;
    //单价*数量
    private Integer medicinePrice;
    //该药的数量
    private Integer num;

    public MedicineInformation() {
    }

    public MedicineInformation(String medicineName, Integer medicinePrice, Integer num) {
        this.medicineName = medicineName;
        this.medicinePrice = medicinePrice;
        this.num = num;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Integer getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(Integer medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
