package com.itau.casepix.config;

import com.itau.casepix.exceptions.DuplicateKeyPixException;
import com.itau.casepix.exceptions.NotFoundException;
import org.springdoc.api.ErrorMessage;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintDefinitionException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {DuplicateKeyException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage resourceDuplicateKeyException(DuplicateKeyException dex, WebRequest request) {
        return defaultResponse(dex);
    }

    @ExceptionHandler(value = {DuplicateKeyPixException.class})
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorMessage resourceDuplicateKeyPixException(DuplicateKeyPixException dex, WebRequest request) {
        return defaultResponse(dex);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(NotFoundException nex, WebRequest request) {
        return defaultResponse(nex);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            var fieldName = "error";
            try {
                fieldName = ((FieldError) error).getField();
            } catch (Exception fieldEx ) {
                System.out.println("Not a field error");
            }
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    private ErrorMessage defaultResponse(Exception ex) {
        return new ErrorMessage(ex.getMessage());
    }
}
