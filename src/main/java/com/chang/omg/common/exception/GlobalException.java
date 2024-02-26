package com.chang.omg.common.exception;

public class GlobalException extends BusinessException {

    public GlobalException(final ExceptionCode exceptionCode, final Object... rejectedValues) {
        super(exceptionCode, rejectedValues);
    }
}
