package br.com.fiap.tokenaccess.function;

import br.com.fiap.tokenaccess.exception.BadRequest;
import br.com.fiap.tokenaccess.exception.ExceptionResponse;
import br.com.fiap.tokenaccess.exception.InternalServerError;
import br.com.fiap.tokenaccess.exception.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FunctionHandler {
    @ExceptionHandler(value = {NotFound.class})
    public ResponseEntity<Object> handleNotFound(final NotFound ex) {
        final HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        final ExceptionResponse response = new ExceptionResponse(ex.getMessage(), httpStatus);
        return new ResponseEntity<>(response, httpStatus);
    }

    @ExceptionHandler(value = {BadRequest.class})
    public ResponseEntity<Object> handleBadRequest(final BadRequest ex) {
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        final ExceptionResponse response = new ExceptionResponse(ex.getMessage(), httpStatus);
        return new ResponseEntity<>(response, httpStatus);
    }

    @ExceptionHandler(value = {InternalServerError.class})
    public ResponseEntity<Object> handleInternalServerError(final InternalServerError ex) {
        final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        final ExceptionResponse response = new ExceptionResponse(ex.getMessage(), httpStatus);
        return new ResponseEntity<>(response, httpStatus);
    }
}