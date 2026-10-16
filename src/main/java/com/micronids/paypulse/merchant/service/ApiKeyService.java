package com.micronids.paypulse.merchant.service;

import com.micronids.paypulse.merchant.dto.request.CreateApiKeyRequest;
import com.micronids.paypulse.merchant.dto.response.CreateApiKeyResponse;

import java.util.UUID;

public interface ApiKeyService {
    CreateApiKeyResponse createApiKey(CreateApiKeyRequest createApiKeyRequest, UUID merchantId);
}
