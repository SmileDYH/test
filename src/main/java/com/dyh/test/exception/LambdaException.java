package com.dyh.test.exception;

/**
 * description: lambda兼容跳出循环exception
 * author: dyh
 * date: 2021/4/21 0021 11:38
 */
public class LambdaException extends RuntimeException {

    private String message;

    private Integer errocode;

    public LambdaException(String message, Integer errocode) {
        super(message);
        this.errocode = errocode;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getErrocode() {
        return errocode;
    }
}
