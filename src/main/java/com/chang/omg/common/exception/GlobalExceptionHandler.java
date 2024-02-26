package com.chang.omg.common.exception;

import static com.chang.omg.common.exception.GlobalExceptionCode.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(final Exception exception) {
        log.error("{}", GLOBAL_INTERNAL_SERVER_ERROR, exception);

        return ResponseEntity.status(GLOBAL_INTERNAL_SERVER_ERROR.getStatus())
                .body(new ErrorResponse(GLOBAL_INTERNAL_SERVER_ERROR.getCode()));
    }
}
