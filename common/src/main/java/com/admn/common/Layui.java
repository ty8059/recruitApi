package com.admn.common;

import java.util.HashMap;
import java.util.List;

public class Layui extends HashMap<String, Object> {

    private int code;
    private String msg;
    private int count;
    private Object data;

    public Layui() {};

    public Layui(String msg) {
        this.msg = msg;
    }

    public Layui(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Layui data(int count,List<?> data, String msg){
        Layui layui = new Layui();
        layui.put("code", 0);
        layui.put("msg", msg);
        layui.put("count", count);
        layui.put("data", data);
        return layui;
    }

    public static Layui error(String msg) {
        Layui layui = new Layui();
        layui.put("msg", msg);
        return layui;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
