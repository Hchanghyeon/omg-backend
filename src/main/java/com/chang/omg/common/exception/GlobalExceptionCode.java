package com.chang.omg.common.exception;

import static org.springframework.http.HttpStatus.*;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GlobalExceptionCode implements ExceptionCode {

    GLOBAL_INTERNAL_SERVER_ERROR(INTERNAL_SERVER_ERROR, "GLO-001", "서버 내부 에러가 발생하였습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
