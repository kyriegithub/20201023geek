package com.example.geek.model.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangzuoxu on 2018/4/27.
 */
public class ResponseBase implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonView(BaseView.class)
    private String returnCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonView(BaseView.class)
    private String returnMsg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonView(BaseView.class)
    private List<Field> fields;

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public interface BaseView {}
}
