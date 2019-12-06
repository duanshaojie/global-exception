package com.exception.globalexception.common;

/**
 * <p><b>@name:</b> BusinessException.java</p>
 * <p><b>@title:</b> 业务处理异常</p>
 * <p>@description: </p>
 * <p>@author: <font color='blue'>Edison</font></p>
 * <p>@time: 2019年12月05日 20点26分</p>
 * <p>
 * 桃之夭夭,灼灼其华
 */
public class BusinessException extends RuntimeException {

    private Throwable throwable;

    private String message;

    private Integer errorCode;

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(String message, Integer errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public BusinessException(String message, Integer errorCode, Throwable throwable) {
        this.message = message;
        this.errorCode = errorCode;
        this.throwable = throwable;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public BusinessException setThrowable(Throwable throwable) {
        this.throwable = throwable;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public BusinessException setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public BusinessException setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }
}
