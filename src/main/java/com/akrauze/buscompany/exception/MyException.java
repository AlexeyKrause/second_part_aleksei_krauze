package com.akrauze.buscompany.exception;


public class MyException extends Exception{
    private ErrorCode errorCode;



    public MyException(ErrorCode message) {
        super(message.toString());
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
