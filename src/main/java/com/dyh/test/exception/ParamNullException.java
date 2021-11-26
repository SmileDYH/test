package com.dyh.test.exception;

public class ParamNullException extends RuntimeException {
    private String message;
    private Integer errocode;
    public ParamNullException(String message, Integer errocode) {
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