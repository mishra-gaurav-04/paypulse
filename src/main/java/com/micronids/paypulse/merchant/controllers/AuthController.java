package com.micronids.paypulse.merchant.controllers;

import com.micronids.paypulse.merchant.dto.request.MerchantSignUpRequest;
import com.micronids.paypulse.merchant.dto.response.MerchantSignUpResponse;
import com.micronids.paypulse.merchant.entity.Merchant;
import com.micronids.paypulse.merchant.service.AuthService;
import com.micronids.paypulse.shared.constants.AppConstants;
import com.micronids.paypulse.shared.generic.AppResponse;
import com.micronids.paypulse.shared.utils.BuildAppResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AppResponse<MerchantSignUpResponse>> singup(@RequestBody @Valid MerchantSignUpRequest request){
       MerchantSignUpResponse response = authService.signup(request);
       return ResponseEntity.status(HttpStatus.CREATED)
               .body(BuildAppResponse.buildAppResponse(
                       AppConstants.MERCHANT_CREATED,response
               ));
    }
}
