package com.chang.omg.common.exception;

import lombok.Getter;

@Getter
public class ApiException extends BusinessException {

    public ApiException(final ExceptionCode exceptionCode, final Object... rejectedValues) {
        super(exceptionCode, rejectedValues);
    }
}
