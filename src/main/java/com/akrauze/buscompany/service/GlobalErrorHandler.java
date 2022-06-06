package com.akrauze.buscompany.service;

import com.akrauze.buscompany.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MyError handleValidationMethodArgumentNotValidException(MethodArgumentNotValidException exc) {
        final MyError error = new MyError();
        exc.getBindingResult().getFieldErrors().forEach(fieldError-> {
            error.getAllErrors().add(String.format("Field %s:%s", fieldError.getField(), fieldError.getDefaultMessage()));
        });
        exc.getBindingResult().getGlobalErrors().forEach(err-> {
            error.getAllErrors().add(String.format("global:%s", err.getDefaultMessage()));
        });
        log.info("MethodArgumentNotValidException {errors} - " + error);
        return error;
    }

    @ExceptionHandler({MyException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public MyError handleValidationMyException(MyException exc) {
        final MyError error = new MyError();

        String str = exc.getMessage();
        error.getAllErrors().add(exc.getCause().toString());
        log.info("MyException {errors} - " + error);
        return error;
    }

    @ExceptionHandler({Exception.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public MyError handleValidationException(Exception exc) {
        final MyError error = new MyError();

        String str = exc.getMessage();
        error.getAllErrors().add(exc.getCause().toString());
        log.info("MyException {errors} - " + error);
        return error;
    }

    public static class MyError {
        private List<String> allErrors = new ArrayList<>();

        public List<String> getAllErrors() {
            return allErrors;
        }

        public void setAllErrors(List<String> allErrors) {
            this.allErrors = allErrors;
        }
    }
}
