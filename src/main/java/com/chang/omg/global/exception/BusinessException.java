package com.chang.omg.global.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ExceptionCode exceptionCode;
    private final Object[] rejectedValues;

    public BusinessException(final ExceptionCode exceptionCode, final Object... rejectedValues) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
        this.rejectedValues = rejectedValues;
    }
}
