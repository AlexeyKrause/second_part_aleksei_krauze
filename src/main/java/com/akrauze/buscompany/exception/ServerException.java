package com.akrauze.buscompany.exception;


public class ServerException extends Exception{
    private ErrorCode errorCode;


    public ServerException(ErrorCode message) {
        super(message.toString());
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
