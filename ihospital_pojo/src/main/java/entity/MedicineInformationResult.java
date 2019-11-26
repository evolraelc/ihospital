package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author RUANBY
 * @date 2019/11/23 2:14
 */
public class MedicineInformationResult implements Serializable {
    private Integer total;
    private List<MedicineInformation> medicineRows;

    public MedicineInformationResult() {
    }

    public MedicineInformationResult(Integer total, List<MedicineInformation> medicineRows) {
        this.total = total;
        this.medicineRows = medicineRows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<MedicineInformation> getMedicineRows() {
        return medicineRows;
    }

    public void setMedicineRows(List<MedicineInformation> medicineRows) {
        this.medicineRows = medicineRows;
    }
}
