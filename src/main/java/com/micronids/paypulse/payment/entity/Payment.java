package com.micronids.paypulse.payment.entity;

import com.micronids.paypulse.shared.entityObjects.Money;
import com.micronids.paypulse.shared.enums.PaymentMethod;
import com.micronids.paypulse.shared.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "payment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "order_id",nullable = false)
    private OrderRecord orderRecord;

    @Column(nullable = false,name = "merchant_id")
    private UUID merchantId;

    @Embedded
    private Money amount;

    @Column(nullable = false, length = 100)
    private String idempotencyKey;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod method;

    @JdbcTypeCode((SqlTypes.JSON))
    @Column(name = "method_details", columnDefinition = "jsonb")
    private Map<String,Object> methodDetails;

    @Column(length = 100,name = "bank_reference")
    private String bankReference;

    @Column(length = 100,name = "error_code")
    private String errorCode;

    @Column(length = 100,name = "error_description")
    private String errorDescription;

    @Column(name = "authorized_at")
    private LocalDateTime authorizedAt;

    @Column(name = "captured_at")
    private LocalDateTime capturedAt;

    @Column(name = "failed_at")
    private LocalDateTime failedAt;

    @Column(name = "refunded_at")
    private LocalDateTime refundedAt;

    @Column(name = "settled_at")
    private LocalDateTime settledAt;


}
