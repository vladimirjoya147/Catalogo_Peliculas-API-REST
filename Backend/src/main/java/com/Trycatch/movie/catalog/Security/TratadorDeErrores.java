package com.Trycatch.movie.catalog.Security;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> tratarError404() {
        ErrorResponse errorResponse = new ErrorResponse("Entity not found", "La entidad solicitada no fue encontrada en la base de datos");

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> tratarError403() {
        ErrorResponse errorResponse = new ErrorResponse("Forbidden", "No tienes permiso para la solicitud");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
    }

    private record ErrorResponse(String Message, String details){}


}
