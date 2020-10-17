package com.example.geek.model.response;


import com.alibaba.fastjson.JSONObject;
import com.example.geek.exception.CustomizedException;
import com.example.geek.model.enums.response.ErrorCodeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author: zhanglu
 * @create: 2018/06/21 18:37
 * @description:
 */
public class Result<T> {

    private static final Logger logger = LoggerFactory.getLogger(Result.class);

    private String returnMsg;
    private String returnCode;
    private T data;
    private List<Field> fields = Collections.EMPTY_LIST;

    public static Result success() {
        return new Result().returnCode(ErrorCodeEnum.SUCCESS.code()).returnMsg(ErrorCodeEnum.SUCCESS.value());
    }

    public static Result success(Object data) {
        return success().data(data);
    }

    public static Result successPage(List data, Page page) {
        PageData pageData = new PageData(data);
        if (page != null) {
            pageData.setPageBean(new PageBean(page.getPageNum(), page.getPageSize(), page.getTotal()));
        }
        return success().data(pageData);
    }

    public static Result successPage(List data, Query query) {
        PageInfo pageInfo = new PageInfo(data);
        PageData pageData = new PageData(data);
        if (query != null) {
            pageData.setPageBean(new PageBean(query.getPageNo(), query.getPageSize(), pageInfo.getTotal()));
        }
        return success().data(pageData);
    }

    public static Result successList(List data) {
        JSONObject items = new JSONObject();
        items.put("items", data);
        return success().data(items);
    }

    public static Result paramError(String msg) {
        return new Result().returnCode(ErrorCodeEnum.PARAM_ERROR.code()).returnMsg(msg);
    }

    public static Result paramError(String msg, List<Field> fields) {
        return paramError(msg).fields(fields);
    }

    public static Result serverError(String msg) {
        return new Result().returnCode(ErrorCodeEnum.EXPECTATION_FAILED.code()).returnMsg(msg);
    }

    public static Result error(String code, String msg) {
        return new Result().returnCode(code).returnMsg(msg);
    }

    public static Result paramError(String code, String msg, List<Field> fields) {
        return new Result().returnCode(code).returnMsg(msg).fields(fields);
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public Result<T> returnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
        return this;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public Result<T> returnCode(String returnCode) {
        this.returnCode = returnCode;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> data(T data) {
        this.data = data;
        return this;
    }

    public List<Field> getFields() {
        return fields;
    }

    public Result<T> fields(List<Field> fields) {
        this.fields = fields;
        return this;
    }

    public boolean isSuccess() {
        return ErrorCodeEnum.SUCCESS.code().equals(returnCode);
    }


    public T feginResult() {
        if (!this.isSuccess()) {
            logger.warn("远程服务出现异常：code -> {} , msg -> {} " , this.returnCode , this.returnMsg);
            throw new CustomizedException("远程接口服务调用出现异常");
        }
        return this.getData();
    }


    public  <R> void eachPageItems( Consumer<R> consumer) {
        List<R> pageItems = this.getPageItems();
        pageItems.forEach(consumer);
    }

    @JsonIgnore
    public <R> List<R> getPageItems() {
        if (this.getData() == null || !(this.getData() instanceof PageData)) {
            return new ArrayList<>();
        }
        return ((PageData<R>)this.getData()).getItems();
    }

}
