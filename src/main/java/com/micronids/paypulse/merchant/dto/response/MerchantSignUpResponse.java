package com.micronids.paypulse.merchant.dto.response;

import com.micronids.paypulse.shared.enums.BusinessType;
import com.micronids.paypulse.shared.enums.MerchantStatus;
import lombok.Builder;

import java.util.UUID;

@Builder
public record MerchantSignUpResponse(
        UUID id,
        String name,
        String email,
        String businessName,
        BusinessType businessType,
        MerchantStatus merchantStatus
) {
}
