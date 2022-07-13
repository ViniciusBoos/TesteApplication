package com.github.viniciusboos.TestSelect.controller;

import com.github.viniciusboos.TestSelect.exception.NoEmptyFieldException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<String> handlerMethodNotValidException(MethodArgumentNotValidException exception){
        return exception.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
    }

    @ExceptionHandler(NoEmptyFieldException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerMethodNotValidException(NoEmptyFieldException exception){
        return exception.getMessage();
    }
}
