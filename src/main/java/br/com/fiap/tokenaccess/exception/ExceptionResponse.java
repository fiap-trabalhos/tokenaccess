package br.com.fiap.tokenaccess.exception;

import org.springframework.http.HttpStatus;

public record ExceptionResponse(
        String message,
        HttpStatus httpStatus
) {
}