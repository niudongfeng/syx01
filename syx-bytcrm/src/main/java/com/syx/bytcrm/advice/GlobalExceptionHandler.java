package com.syx.bytcrm.advice;

import com.baomidou.mybatisplus.extension.api.R;
import com.syx.bytcrm.exp.ParameterFormatException;
import com.syx.bytcrm.exp.UserNotFoundException;
import com.syx.bytcrm.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 牛东峰
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 所有异常处理
     *
     * @param e     捕获的异常
     * @return      异常描述
     */
    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        log.info("服务器异常日志", e);
        return new R<>().setCode(ResultUtil.EXCEPTION_CODE).setMsg("服务器错误，请联系管理员。").setData(ResultUtil.EMPTY);
    }

    /**
     * 请求方式异常处理
     *
     * @param e     捕获的异常
     * @return      异常描述
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R handleException(HttpRequestMethodNotSupportedException e) {
        log.info("请求方式错误", e);
        return new R<>().setCode(ResultUtil.PATAM_EXCEPTION_CODE).setMsg("请求方式错误").setData(ResultUtil.EMPTY);
    }

    /**
     * 参数格式异常处理
     *
     * @param e     捕获的异常
     * @return      异常描述
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public R handleException(HttpMediaTypeNotSupportedException e) {
        log.info("请求Content-Type错误（正确为：application/json）", e);
        return new R<>().setCode(ResultUtil.PATAM_EXCEPTION_CODE).setMsg("请求Content-Type错误").setData(ResultUtil.EMPTY);
    }

    /**
     * 参数格式异常处理
     *
     * @param e     捕获的异常
     * @return      异常描述
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R handleException(HttpMessageNotReadableException e) {
        log.info("参数不是JSON格式", e);
        return new R<>().setCode(ResultUtil.PATAM_EXCEPTION_CODE).setMsg("参数不是JSON格式").setData(ResultUtil.EMPTY);
    }

    /**
     * 参数格式异常处理
     *
     * @param e     捕获的异常
     * @return      异常描述
     */
    @ExceptionHandler(ParameterFormatException.class)
    public R handleException(ParameterFormatException e) {
        log.info("请求参数不能为空", e);
        return new R<>().setCode(ResultUtil.PATAM_EXCEPTION_CODE).setMsg("请求参数不能为空").setData(ResultUtil.EMPTY);
    }

    /**
     * 参数错误异常处理
     *
     * @param e     捕获的异常
     * @return      异常描述
     */
    @ExceptionHandler({IllegalArgumentException.class})
    public R handleException(IllegalArgumentException e){
        return new R<>().setCode(ResultUtil.PATAM_CODE).setMsg(e.getMessage()).setData(ResultUtil.EMPTY);
    }

    /**
     * 用户没有发现异常处理
     *
     * @param e     捕获的异常
     * @return      异常描述
     */
    @ExceptionHandler({UserNotFoundException.class})
    public R handleException(UserNotFoundException e){
        return new R<>().setCode(ResultUtil.NOT_FOUND_CODE).setMsg(e.getMessage()).setData(ResultUtil.EMPTY);
    }
}
