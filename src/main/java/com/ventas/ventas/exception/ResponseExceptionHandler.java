package com.ventas.ventas.exception;


import com.ventas.ventas.VentasApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentasApplication.class);
    //Creamos un POJO (ExceptionResponse) para hacer los mensajes personalizados
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> manejarExcepciones(Exception e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                "Ocurrió un error",
                e.getMessage());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOGGER.trace("this is a tracer message");
        LOGGER.debug("this is a debug message");
        LOGGER.info("Info");


        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });


        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                "Ocurrió un error",
                ex.getMessage(),
                errors);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
