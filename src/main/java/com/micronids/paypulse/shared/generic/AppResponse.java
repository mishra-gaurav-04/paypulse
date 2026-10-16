package com.micronids.paypulse.shared.generic;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonPropertyOrder({ "success", "message", "data" })
public class AppResponse<T> {
    private final boolean success;
    private final String message;
    private final T data;
}
