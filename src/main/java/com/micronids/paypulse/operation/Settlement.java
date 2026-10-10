package com.micronids.paypulse.operation;

import com.micronids.paypulse.shared.entityObjects.Money;
import com.micronids.paypulse.shared.enums.SettlementStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "settlement")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Settlement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "merchant_id",nullable = false)
    private UUID merchantId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "gross_amount_units",nullable = false)),
            @AttributeOverride(name = "currencyCode",column = @Column(name = "gross_amount_currency_code",nullable = false))
    })
    private Money grossAmount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "refund_amount_units",nullable = false)),
            @AttributeOverride(name = "currencyCode",column = @Column(name = "refund_amount_currency_code",nullable = false))
    })
    private Money refundAmount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "fee_amount_units",nullable = false)),
            @AttributeOverride(name = "currencyCode",column = @Column(name = "fee_amount_currency_code",nullable = false))
    })
    private Money feeAmount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "gst_fee_amount_units",nullable = false)),
            @AttributeOverride(name = "currencyCode",column = @Column(name = "gst_fee_amount_currency_code",nullable = false))
    })
    private Money gstFeeAmount;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "net_amount_units",nullable = false)),
            @AttributeOverride(name = "currencyCode",column = @Column(name = "net_amount_currency_code",nullable = false))
    })
    private Money netAmount;

    @Column(name = "bank_reference",nullable = false,length = 100)
    private String bankReference;

    @Enumerated(EnumType.STRING)
    @Column(name = "settlement_status", length = 50)
    private SettlementStatus status = SettlementStatus.INITIATED;

    private LocalDateTime processedAt;
}
