package com.micronids.paypulse.merchant.service.impl;

import com.micronids.paypulse.merchant.dto.request.MerchantSignUpRequest;
import com.micronids.paypulse.merchant.dto.response.MerchantSignUpResponse;
import com.micronids.paypulse.merchant.entity.AppUser;
import com.micronids.paypulse.merchant.entity.Merchant;
import com.micronids.paypulse.merchant.repository.AppUserRepository;
import com.micronids.paypulse.merchant.repository.MerchantRepository;
import com.micronids.paypulse.merchant.service.AuthService;
import com.micronids.paypulse.shared.enums.MerchantStatus;
import com.micronids.paypulse.shared.enums.UserRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final MerchantRepository merchantRepository;
    private final AppUserRepository appUserRepository;

    @Override
    public MerchantSignUpResponse signup(MerchantSignUpRequest request) {
        if(merchantRepository.existsByEmail(request.email())){
            throw new RuntimeException("Merchant with this email already exists: "+request.email());
        }

        Merchant merchant = Merchant.builder()
                .businessName(request.businessName())
                .businessType(request.businessType())
                .name(request.name())
                .email(request.email())
                .status(MerchantStatus.PENDING_KYC)
                .build();

        merchant = merchantRepository.save(merchant);

        AppUser appUser = AppUser.builder()
                .email(request.email())
                .merchant(merchant)
                .passwordHash(request.password()) // TODO need to hash the password using bcrypt
                .userRole(UserRole.OWNER)
                .build();

        appUser = appUserRepository.save(appUser);

        return MerchantSignUpResponse.builder()
                .id(merchant.getId())
                .name(merchant.getName())
                .email(merchant.getEmail())
                .businessName(merchant.getBusinessName())
                .businessType(merchant.getBusinessType())
                .merchantStatus(merchant.getStatus())
                .build();
    }
}
