package entity;

import java.io.Serializable;

/**
 * @program: ihospital
 * @description: 存放后端插入更新等操作的返回结果
 * @author: Mr.King
 * @create: 2019-11-17 13:33
 **/

public class Result implements Serializable {
    //是否成功
    private boolean success;
    //提示信息
    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
