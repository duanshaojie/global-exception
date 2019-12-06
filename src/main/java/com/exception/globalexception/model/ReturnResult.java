package com.exception.globalexception.model;

/**
 * <p><b>@name:</b> ReturnResult.java</p>
 * <p><b>@title:</b> 统一返回</p>
 * <p>@description: </p>
 * <p>@author: <font color='blue'>Edison</font></p>
 * <p>@time: 2019年12月05日 20点37分</p>
 * <p>
 * 桃之夭夭,灼灼其华
 */
public class ReturnResult {

    private Boolean result;

    private String msg;

    private Object data;

    private ReturnResult(boolean result, Object data, String message) {
        this.result = result;
        this.msg = message;
        this.data = data;
    }

    public static ReturnResult instance(boolean result, Object data, String message) {
        return new ReturnResult(result, data, message);
    }

    public Boolean getResult() {
        return result;
    }

    public ReturnResult setResult(Boolean result) {
        this.result = result;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ReturnResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ReturnResult setData(Object data) {
        this.data = data;
        return this;
    }
}

