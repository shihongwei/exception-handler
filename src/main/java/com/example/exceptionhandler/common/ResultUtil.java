package com.example.exceptionhandler.common;

import org.springframework.util.StringUtils;

public class ResultUtil {

    /**
     * @param t
     * @param <T> 用来声明泛型方法
     * @return
     */
    public static <T> Result<T> success(T t) {
        Result<T> result = new Result<>();
        result.setIsSuccess(Boolean.TRUE);
        result.setResultCode(0);
        result.setResultMessage("成功");
        result.setData(t);
        return result;
    }



    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setIsSuccess(Boolean.FALSE);
        result.setResultCode(code == null ? -1 : code);
        result.setResultMessage(StringUtils.isEmpty(msg) ? "失败" : msg);
        return result;
    }
}
