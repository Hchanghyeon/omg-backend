package com.chang.omg.common.exception;

import static org.springframework.http.HttpStatus.*;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiExceptionCode implements ExceptionCode {
    API_INTERNAL_SERVER_ERROR(INTERNAL_SERVER_ERROR, "API-001", "게임사 서버에 에러가 발생하였습니다."),
    API_BAD_REQUEST(BAD_REQUEST, "API-002", "요청 정보가 잘못되었습니다."),
    API_FORBIDDEN(FORBIDDEN, "API-003", "요청 권한이 없습니다."),
    API_TOO_MANY_REQUESTS(TOO_MANY_REQUESTS, "API_004", "요청이 너무 많습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}