package com.micronids.paypulse.shared.generic;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Map;

@Getter
@Setter
@Builder
@JsonPropertyOrder({"success","timestamp","status","error","message","path","errors"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse<T> {
    private final Boolean success;
    private final Instant timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;
    private final T errors;
}
