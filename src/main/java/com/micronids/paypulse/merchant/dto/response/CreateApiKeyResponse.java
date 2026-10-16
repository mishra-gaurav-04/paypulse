package com.micronids.paypulse.merchant.dto.response;

import com.micronids.paypulse.shared.enums.ApiKeyEnvironment;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateApiKeyResponse(
        UUID id,
        String keyId,
        String keySecret,
        ApiKeyEnvironment environment
) {
}
