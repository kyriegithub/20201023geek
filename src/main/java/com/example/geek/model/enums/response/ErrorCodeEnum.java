package com.example.geek.model.enums.response;

public enum ErrorCodeEnum {

    FAILED_TOO_MANY_TIMES("failed.too.many.times", "失败次数太多！"),
    ACCOUNT_NOT_FOUND("account.not.found", "账户不存在"),
    ACCOUNT_PASSWORD_ERROR("account.password.error", "密码错误"),
    ACCOUNT_INVALID("account.invalid", "账号无效"),

    CLINIC_NOT_FOUND("clinic.not.found", "诊所不存在"),

    SUCCESS("success","成功"),
    EXPECTATION_FAILED("expectation.failed","业务条件不符合"),
    SERVER_ERROR("server.error","服务器异常"),
    RESOURCE_NOT_FOUND("resource.not.found","请求的资源不存在"),
    PARAM_ERROR("param.error","参数校验错误"),
    UNAUTHORIZED("unauthorized", "未登录"),
    GET_REDIS_LOCK_FAILED("1002", "获取REDIS锁失败"),
    NO_PERMISSION("no.permission", "无权限");

    String value;
    String code;

    public String value() {
        return value;
    }

    public void value(String value) {
        this.value = value;
    }

    public String code() {
        return code;
    }

    public void code(String code) {
        this.code = code;
    }

    ErrorCodeEnum(String code, String value) {
        this.code = code;
        this.value=value;
    }
}
