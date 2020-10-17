package com.example.geek.model.enums.response;

public enum ResponseStatusEnum {


    /**
     * stauts 为200等
     */
    SUCCESS("success", "成功"),

    /**
     * 服务器内部无法处理的异常，status 为500等
     */
    SERVER_ERROR("service.error", "服务器异常"),

    /**
     * status为404
     * 方法不存在等
     */
    RESOURCE_NOT_FOUND("source.not.found", "请求的资源不存在"),

    STORAGE_NOT_ENOUGH("storage.not.enough","库存不足"),
    /**
     * 参数校验错误，status为400
     */
    PARAM_VALIDATION("param.validation.error", "参数校验错误"),
    UNAUTHORIZED("unauthorized", "未登录");




    String value;

    String code;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    ResponseStatusEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
