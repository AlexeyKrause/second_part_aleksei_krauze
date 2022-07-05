package com.akrauze.buscompany.exception;

import lombok.Data;

@Data
public class ServerException extends Exception{
    private ErrorCode errorCode;
    private String field;


    public ServerException(ErrorCode errorCode, String field) {
        super();
        this.errorCode= errorCode;
        this.field = field;
    }
}
