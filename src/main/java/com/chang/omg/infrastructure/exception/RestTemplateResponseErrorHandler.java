package com.chang.omg.infrastructure.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import com.chang.omg.common.exception.ApiException;
import com.chang.omg.common.exception.ApiExceptionCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(final ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is5xxServerError() ||
                response.getStatusCode().is4xxClientError();
    }

    @Override
    public void handleError(final ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is5xxServerError()) {
            throw new ApiException(ApiExceptionCode.API_INTERNAL_SERVER_ERROR);
        }

        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new ApiException(ApiExceptionCode.API_BAD_REQUEST);
        }

        if (response.getStatusCode() == HttpStatus.FORBIDDEN) {
            throw new ApiException(ApiExceptionCode.API_FORBIDDEN);
        }

        if (response.getStatusCode() == HttpStatus.TOO_MANY_REQUESTS) {
            throw new ApiException(ApiExceptionCode.API_TOO_MANY_REQUESTS);
        }
    }
}
