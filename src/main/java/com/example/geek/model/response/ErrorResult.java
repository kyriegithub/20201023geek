package com.example.geek.model.response;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzuoxu on 2018/5/3.
 */
public class ErrorResult extends ResponseBase {


    public static ErrorResult build (String returnCode, String returnMsg, List list) {
        ErrorResult result = new ErrorResult();
        result.setReturnCode(returnCode);
        result.setReturnMsg(returnMsg);

        if (!CollectionUtils.isEmpty(list)) {
            List<Field> fieldList = new ArrayList<Field>();
            Field field = null;
            for(Object object: list){
                if(object instanceof FieldError){
                    field = new Field();
                    field.setField(((FieldError) object).getField());
                    field.setMessage(((FieldError) object).getDefaultMessage());
                    fieldList.add(field);
                }else {
                    fieldList.add((Field) object);
                }
            }
            result.setFields(fieldList);
        }

        return result;
    }

    public static ErrorResult build (String returnCode, String returnMsg) {
        ErrorResult result = new ErrorResult();
        result.setReturnCode(returnCode);
        result.setReturnMsg(returnMsg);
        return result;
    }

//    public String getReturnCode() {
//        return returnCode;
//    }
//
//    public void setReturnCode(String returnCode) {
//        this.returnCode = returnCode;
//    }
//
//    public String getReturnMsg() {
//        return returnMsg;
//    }
//
//    public void setReturnMsg(String returnMsg) {
//        this.returnMsg = returnMsg;
//    }
//
//    public enums Type {
//        BAD_REQUEST_ERROR("error.badrequest", "Bad request error"),
//        INTERNAL_SERVER_ERROR("error.internalserver", "Unexpected server error"),
//        VALIDATION_ERROR("error.validation", "Found validation issues");
//
//        private String returnCode;
//        private String returnMsg;
//
//        Type(String returnCode, String returnMsg) {
//            this.returnCode = returnCode;
//            this.returnMsg = returnMsg;
//        }
//
//        public String getReturnCode() {
//            return returnCode;
//        }
//
//        public void setReturnCode(String returnCode) {
//            this.returnCode = returnCode;
//        }
//
//        public String getReturnMsg() {
//            return returnMsg;
//        }
//
//        public void setReturnMsg(String returnMsg) {
//            this.returnMsg = returnMsg;
//        }
//    }
}