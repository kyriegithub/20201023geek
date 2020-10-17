package com.example.geek.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by caojianyi on 2018/5/3.
 */
public class CustomizedException extends BaseException{

    private int statusCode = HttpStatus.OK.value();

    @Override
    public String getMessage(){
        return this.getReturnMsg();
    }

    /**
     * @param statusCode 自定义statusCode
     * @param returnCode
     */
    public CustomizedException (int statusCode, String returnCode) {
        this.statusCode = statusCode;
    }



    public CustomizedException (String returnCode, String returnMsg) {
        super(returnCode,returnMsg);
    }

    public CustomizedException (String returnCode, String... args) {
        super(returnCode, args);
    }

    public CustomizedException(int statusCode) {
        this.statusCode = statusCode;
    }

    public CustomizedException(String returnCode, int statusCode, String... args) {
        super(returnCode, args);
        this.statusCode = statusCode;
    }

    public CustomizedException(String returnCode, String message, Throwable cause, int statusCode) {
        super(returnCode, message, cause);
        this.statusCode = statusCode;
    }

    public CustomizedException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public CustomizedException(String message, Throwable cause, int statusCode) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public CustomizedException(Throwable cause, int statusCode) {
        super(cause);
        this.statusCode = statusCode;
    }

    public CustomizedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int statusCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

}
