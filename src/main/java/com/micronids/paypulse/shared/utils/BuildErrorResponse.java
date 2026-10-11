package com.micronids.paypulse.shared.utils;

import com.micronids.paypulse.shared.generic.AppResponse;
import com.micronids.paypulse.shared.generic.ErrorResponse;
import org.springframework.http.HttpStatus;

import java.time.Instant;

public class BuildErrorResponse {
    private BuildErrorResponse(){}

    public static <T>ErrorResponse<T> buildErrorResponse(
            HttpStatus status,
            String message,
            String path,
            T errors
    ){
        return ErrorResponse.<T>builder()
                .timestamp(Instant.now())
                .message(message)
                .status(status.value())
                .path(path)
                .error(status.getReasonPhrase())
                .errors(errors)
                .build();

    }

}