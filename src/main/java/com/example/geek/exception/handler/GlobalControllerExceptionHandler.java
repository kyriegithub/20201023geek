package com.example.geek.exception.handler;



import com.example.geek.config.PropertiesConfig;
import com.example.geek.exception.CustomizedException;
import com.example.geek.exception.ParamVerificationException;
import com.example.geek.model.enums.response.ErrorCodeEnum;
import com.example.geek.model.enums.response.ResponseStatusEnum;
import com.example.geek.model.response.ErrorResult;
import com.example.geek.model.response.Field;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caojianyi on 2018/5/3.
 */
@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

    /**
     * 自定义statusCode返回异常
     *
     * @param response
     * @param ex
     * @return
     * @throws IOException
     */
    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(CustomizedException.class)
    @ResponseBody
    public ErrorResult handleCustomizedException(HttpServletResponse response, CustomizedException ex) throws IOException {
        log.error("业务异常", ex);
        response.setStatus(ex.getStatusCode());
        String returnMsg = ex.getReturnMsg();
        if (StringUtils.isBlank(ex.getReturnMsg())) {
            returnMsg = PropertiesConfig.getContextProperty(ex.getReturnCode(), ex.getArgs());
        }
        return ErrorResult.build(ex.getReturnCode(), returnMsg);
    }




    /**
     * 请求方法不存在，返回404
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public ErrorResult handleException(NoHandlerFoundException ex) {
        log.error("请求方法不存在", ex);
        String returnMsg = PropertiesConfig.getContextProperty("error.serverError");
        return ErrorResult.build(ResponseStatusEnum.RESOURCE_NOT_FOUND.getCode(), ResponseStatusEnum.RESOURCE_NOT_FOUND.getValue());
    }


    /**
     * 服务器不能处理的异常，返回500
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResult handleException(Exception ex) {
        log.error("服务器不能处理的异常", ex);
        return ErrorResult.build(ResponseStatusEnum.SERVER_ERROR.getCode(), ResponseStatusEnum.SERVER_ERROR.getValue());
    }

    /**
     * 服务器不能处理的异常，返回500
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ErrorResult handleException(RuntimeException ex) {
        log.error("服务器不能处理的异常", ex);
        return ErrorResult.build(ResponseStatusEnum.SERVER_ERROR.getCode(), ResponseStatusEnum.SERVER_ERROR.getValue());
    }

    /**
     * 参数校验错误异常 400
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ParamVerificationException.class)
    @ResponseBody
    public ErrorResult handleParamVerificationException(ParamVerificationException ex) {
        log.error("参数校验错误异常", ex);
        String returnMsg = ex.getReturnMsg();
        if (StringUtils.isBlank(ex.getReturnMsg())) {
            returnMsg = PropertiesConfig.getContextProperty(ex.getReturnCode(), ex.getArgs());
        }
        return ErrorResult.build(ex.getReturnCode(), returnMsg, ex.getFieldList());
    }

    /**
     * 参数校验错误异常 400
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, MissingServletRequestParameterException.class, BindException.class})
    @ResponseBody
    public ErrorResult handleMethodArgumentNotValidException(Exception ex) {
        log.error("参数校验错误异常", ex);
        List list = new ArrayList<>();
        if (ex instanceof MethodArgumentNotValidException) {
            list = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors();
        }
        if (ex instanceof BindException) {
            list = ((BindException) ex).getBindingResult().getFieldErrors();
        }
        if (ex instanceof MissingServletRequestParameterException) {
            Field field = new Field();
            String fieldName = ((MissingServletRequestParameterException) ex).getParameterName();
            String message = PropertiesConfig.getContextProperty("error.param.not.null", fieldName);
            field.setField(fieldName);
            field.setMessage(message);
            list.add(field);
        }
        ErrorResult result = ErrorResult.build("error.param.validation", "参数校验错误", list);
        List<Field> fields = result.getFields();
        String returnMsg = "参数校验错误";
        if (!CollectionUtils.isEmpty(fields)) {
            returnMsg = fields.get(0).getMessage();
        }
        result.setReturnMsg(returnMsg);
        return result;
    }

    /**
     * 数据不可读 500
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ErrorResult handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        log.error("数据不可读", ex);
        ErrorResult result = ErrorResult.build("error.param.messageNotReadable", "数据格式有误");
        return result;
    }

    /**
     * 字段长度过长异常
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ErrorResult handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        log.error("handleDataIntegrityViolationException", ex);
        if (ex.getCause() != null && ex.getCause() instanceof MysqlDataTruncation && ex.getCause().getMessage() != null && ex.getCause().getMessage().contains("Data too long")) {
            return ErrorResult.build(ErrorCodeEnum.PARAM_ERROR.code(), "字段长度过长");
        }
        return handleException(ex);
    }

}
