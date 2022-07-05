package com.akrauze.buscompany.exception;

public enum ErrorCode {
    // REVU добавьте String message - пояснение. См. Задания 8,10
    THE_USER_NOT_FOUND(""),
    THIS_USER_ALREADY_EXIST(""),
    EMPTY_PASSWORD("Пароль не может быть пустым"),
    INVALID_PASSWORD("Неверный пароль"),
    LOGIN_NOT_FOUND("Данный логин не существует"),
    LOGIN_ALREADY_EXIST("Данный логин уже существует, выберете другой логин"),
    YOU_DONT_HAVE_PERMISSIONS("Доступ для вашей роли запрещен");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {return message;}
}
