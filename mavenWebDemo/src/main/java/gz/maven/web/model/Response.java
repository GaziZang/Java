package gz.maven.web.model;

import gz.maven.web.helper.JsonHelper;

/**
 * Created by gazizang on 17/3/19.
 */
public class Response {
    private boolean isSuccess;
    private int code;
    private String message = "test";
    private String data = "test";

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return JsonHelper.objectToJson(this);
    }
}
