package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @program: ihospital
 * @description: 存储通用的分页信息
 * @author: Mr.King
 * @create: 2019-11-16 10:04
 **/

public class PageResult implements Serializable {
    private long total;//总记录数
    private List rows;//当前页记录

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
