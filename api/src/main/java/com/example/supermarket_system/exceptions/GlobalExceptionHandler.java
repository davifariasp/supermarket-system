package com.example.supermarket_system.exceptions;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.example.supermarket_system.controllers")
public class GlobalExceptionHandler {

    @ExceptionHandler(APIException.class)
    public ResponseEntity<String> handleApiException(APIException ex) {
        // Retorna apenas a mensagem da exceção
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        // Para exceções não tratadas, uma mensagem genérica
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + ex.getMessage());
    }
}
