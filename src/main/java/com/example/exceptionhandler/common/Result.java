package com.example.exceptionhandler.common;

import lombok.Data;

@Data
public class Result<T> {

    /** return code */
    private Integer code;

    /** return message */
    private String  msg;

    /** return content */
    private T       data;
}
