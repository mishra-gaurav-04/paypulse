package com.micronids.paypulse.merchant.dto.request;

import com.micronids.paypulse.shared.enums.BusinessType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MerchantSignUpRequest(
        @NotNull(message = "Name is required")
        String name,

        @Email
        @NotNull(message = "Email is required")
        String email,

        @NotNull(message = "password should be required")
        @Size(min = 8, message = "Password should be at least 8 character long ")
        String password,

        @Size(max = 50,message = "Business name should not be more than 50")
        String businessName,
        BusinessType businessType
) {
}
