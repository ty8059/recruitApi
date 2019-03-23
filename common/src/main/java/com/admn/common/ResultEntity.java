package com.admn.common;

public class ResultEntity {

    private boolean success;
    private Object obj;
    private String msg;

    public ResultEntity() {};

    public ResultEntity(boolean success) {
        this.success = success;
    }

    public ResultEntity(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public ResultEntity(boolean success, String msg, Object obj) {
        this.success = success;
        this.msg = msg;
        this.obj = obj;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
