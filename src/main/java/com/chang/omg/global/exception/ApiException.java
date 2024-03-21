package com.chang.omg.global.exception;

import lombok.Getter;

@Getter
public class ApiException extends BusinessException {

    public ApiException(final ExceptionCode exceptionCode, final Object... rejectedValues) {
        super(exceptionCode, rejectedValues);
    }
}
