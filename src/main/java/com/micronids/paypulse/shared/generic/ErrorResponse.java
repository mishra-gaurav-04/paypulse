package com.micronids.paypulse.shared.generic;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Map;

@Getter
@Setter
@Builder
public class ErrorResponse<T> {
    private final Instant timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;
    private final T errors;
}
