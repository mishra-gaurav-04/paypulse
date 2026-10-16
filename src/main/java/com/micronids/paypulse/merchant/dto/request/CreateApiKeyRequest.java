package com.micronids.paypulse.merchant.dto.request;

import com.micronids.paypulse.shared.enums.ApiKeyEnvironment;
import jakarta.validation.constraints.NotNull;

public record CreateApiKeyRequest (
        @NotNull(message = "API Key ENV can not be null")
        ApiKeyEnvironment apiKeyEnvironment
){
}
