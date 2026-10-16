package com.micronids.paypulse.merchant.controllers;

import com.micronids.paypulse.merchant.dto.request.CreateApiKeyRequest;
import com.micronids.paypulse.merchant.dto.response.CreateApiKeyResponse;
import com.micronids.paypulse.merchant.service.ApiKeyService;
import com.micronids.paypulse.shared.constants.AppConstants;
import com.micronids.paypulse.shared.generic.AppResponse;
import com.micronids.paypulse.shared.utils.BuildAppResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("/v1/merchant/{merchantId}/api-keys")
@RequiredArgsConstructor
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    @PostMapping("/create")
    public ResponseEntity<AppResponse<CreateApiKeyResponse>> createApiKey(@PathVariable UUID merchantId,
                                                                          @Valid @RequestBody CreateApiKeyRequest body){
        CreateApiKeyResponse createApiKeyResponse = apiKeyService.createApiKey(body,merchantId);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                BuildAppResponse.buildAppResponse(
                        AppConstants.API_KEY_CREATED,createApiKeyResponse
                ));
    }
}
