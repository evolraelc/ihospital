package entity;

/**
 * @program: ihospital
 * @description: 自定义异常
 * @author: Mr.King
 * @create: 2019-11-17 14:42
 **/

public class MyException extends Exception {
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public MyException(String str){
        super(str);
        this.message=str;
    }


}
