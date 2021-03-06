package com.organOld.oService.contract;

/**
 * Created by Administrator on 2017/1/30.
 */
//将所有的ajax请求返回类型，全部封装成json数据
public class Conse {

    private boolean success;
    private Object data;
    private String error;

    public Conse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }


    public Conse(boolean success) {
        this.success=success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
