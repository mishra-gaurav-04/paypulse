package com.micronids.paypulse.merchant.service.impl;

import com.micronids.paypulse.merchant.dto.request.CreateApiKeyRequest;
import com.micronids.paypulse.merchant.dto.response.CreateApiKeyResponse;
import com.micronids.paypulse.merchant.entity.ApiKey;
import com.micronids.paypulse.merchant.entity.Merchant;
import com.micronids.paypulse.merchant.repository.ApiKeyRepository;
import com.micronids.paypulse.merchant.repository.MerchantRepository;
import com.micronids.paypulse.merchant.service.ApiKeyService;
import com.micronids.paypulse.shared.exceptions.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApiKeyServiceImpl implements ApiKeyService {
    private final ApiKeyRepository apiKeyRepository;
    private final MerchantRepository merchantRepository;

    @Override
    public CreateApiKeyResponse createApiKey(CreateApiKeyRequest createApiKeyRequest, UUID merchantId) {
        Merchant merchant = merchantRepository.findById(merchantId).orElseThrow(() -> new ResourceNotFoundException("merchant",merchantId));

        // TODO Key secret and Key id generation utils
        String keyId = "pplk_"+ createApiKeyRequest.apiKeyEnvironment().name().toLowerCase() + "big_random_string"; // TODO generate big random string
        String rawSecret = "big_random_secret"; // TODO repalce with cryptographic random hex

        ApiKey apiKey = ApiKey.builder()
                .merchant(merchant)
                .keyId(keyId)
                .keySecretHash(rawSecret) // TODO encode with bcrypt
                .apiKeyEnvironment(createApiKeyRequest.apiKeyEnvironment())
                .build();

        apiKey = apiKeyRepository.save(apiKey);

        return CreateApiKeyResponse.builder()
                .id(apiKey.getId())
                .keyId(keyId)
                .keySecret(rawSecret)
                .environment(createApiKeyRequest.apiKeyEnvironment())
                .build();
    }
}
