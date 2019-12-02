package entity;

import java.io.Serializable;

/**
 * @program: ihospital
 * @description: 药品下拉框展示实体
 * @author: Mr.King
 * @create: 2019-11-27 15:55
 **/

public class DrugSelect2 implements Serializable {

    private Long id;

    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
