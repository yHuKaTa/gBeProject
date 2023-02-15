package com.gbe.gBeProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.management.relation.RoleNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandlerException {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFoundException.class)
    String handleUserNotFoundException(UserNotFoundException ex){
        return String.format(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String,String> handleMethodArgNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> handledErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError-> {
            handledErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return handledErrors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RoleNotFoundException.class)
    String handleRoleNotFoundException(RoleNotFoundException ex){
        return String.format("Role not exist.");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    String handleSqlIntegrityViolation(SQLIntegrityConstraintViolationException ex) {
        return "Account with this email exists!";
    }
}
