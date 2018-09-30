package com.example.exceptionhandler.common;

import lombok.Data;

@Data
public class Result<T> {

    private Boolean isSuccess;

    private Integer ResultCode;

    private String  resultMessage;

    private T       data;
}
