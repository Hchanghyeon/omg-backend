package com.chang.omg.global.exception;

public class GlobalException extends BusinessException {

    public GlobalException(final ExceptionCode exceptionCode, final Object... rejectedValues) {
        super(exceptionCode, rejectedValues);
    }
}
