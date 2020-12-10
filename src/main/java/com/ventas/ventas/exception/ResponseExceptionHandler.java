package com.ventas.ventas.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    //Creamos un POJO (ExceptionResponse) para hacer los mensajes personalizados
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> manejarExcepciones(Exception e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Ocurrió un error", e.getMessage());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
