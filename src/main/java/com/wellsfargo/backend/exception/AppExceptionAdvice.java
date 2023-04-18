package com.wellsfargo.backend.exception;

import com.wellsfargo.backend.dto.ExceptionRes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class AppExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InvalidFileTypeException.class})
    public ExceptionRes handleInvalidFileTypeException(InvalidFileTypeException e, HttpServletRequest servletRequest, HttpServletResponse httpServletResponse) {
        return new ExceptionRes(e.getMessage());
    }
}
