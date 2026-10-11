package com.micronids.paypulse.merchant.service;

import com.micronids.paypulse.merchant.dto.request.MerchantSignUpRequest;
import com.micronids.paypulse.merchant.dto.response.MerchantSignUpResponse;
import jakarta.validation.Valid;

public interface AuthService {
    MerchantSignUpResponse signup(MerchantSignUpRequest request);
}
