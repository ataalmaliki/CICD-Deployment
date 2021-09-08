package com.hawaya.socialapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocialControlAdvise {

    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<Object> handleSAExceptions(BusinessException exception) {

        return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
