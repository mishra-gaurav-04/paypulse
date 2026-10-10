package com.micronids.paypulse.merchant.entity;


import com.micronids.paypulse.shared.enums.BusinessType;
import com.micronids.paypulse.shared.enums.MerchantStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "merchant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(length = 12)
    private String contactNumber;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(length = 100)
    private String businessName;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    @Column(length = 200)
    private String merchantWebSiteUrl;

    @Column(length = 20,nullable = false)
    @Enumerated(EnumType.STRING)
    private MerchantStatus merchantStatus = MerchantStatus.PENDING_KYC;

    @Column(length = 20)
    private String gst_id;

    @Column(length = 20)
    private String pan_id;

    @Column(length = 200)
    private String settlementBankAccount;

    @Column(length = 20)
    private String settlementBankIfsc;

    @Column(length = 200)
    private String settlementBankAccountHolderName;

}
