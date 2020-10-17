package com.example.geek.exception;


import com.example.geek.model.response.Field;

import java.util.List;

/**
 * Created by caojianyi on 2018/5/3.
 */
public class ParamVerificationException extends BaseException {

    public ParamVerificationException() {
        super();
    }

    public ParamVerificationException(String returnCode, String... args) {
        super(returnCode, args);
    }

    public ParamVerificationException(String returnCode, List<Field> fieldList) {
        super(returnCode,fieldList);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
