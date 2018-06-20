package com.example.exceptionhandler.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.exceptionhandler.exception.ServiceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e) {
        if (e instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) e;
            return ResultUtil.error(80, "业务操作异常：" + serviceException.getMessage());
        } else {
            log.error("系统异常", e);
            return ResultUtil.error(81, "系统异常");
        }
    }
}
