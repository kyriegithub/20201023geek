package com.example.geek.exception;


import com.example.geek.model.enums.response.ErrorCodeEnum;

/**
 * Created by caojianyi on 2018/7/3.
 */
public class ParamException extends BaseException {

    public ParamException(String returnCode, String returnMsg) {
        super(returnCode,returnMsg);
    }

    public ParamException(String returnMsg) {
        super(ErrorCodeEnum.PARAM_ERROR.code(), returnMsg);
    }

    public ParamException(String returnCode, String returnMsg, Throwable cause) {
        super(returnCode,returnMsg, cause);
    }

    public ParamException(String returnMsg, Throwable cause) {
        super(ErrorCodeEnum.PARAM_ERROR.code(), returnMsg, cause);
    }
}
