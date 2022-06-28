package com.akrauze.buscompany.exception;

import lombok.Data;

@Data
public class ServerException extends Exception{
    private String errorCode;
    private String field;
    private String message;


    public ServerException(String errorCode, String field, String message) {
        super();
        this.errorCode= errorCode;
        this.field = field;
        this.message = message;
    }
}
