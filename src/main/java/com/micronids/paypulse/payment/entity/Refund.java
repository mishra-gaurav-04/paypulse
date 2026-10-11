package com.micronids.paypulse.payment.entity;

import com.micronids.paypulse.shared.entityObjects.Money;
import com.micronids.paypulse.shared.enums.RefundStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "refund")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "payment_id",nullable = false)
    private Payment payment;

    @Column(name = "merchant_id",nullable = false)
    private UUID merchantId;

    @Embedded
    private Money amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 40)
    private RefundStatus status = RefundStatus.PENDING;

    @Column(name = "bank_reference",length = 250)
    private String bankReference;

    @Column(name = "error_code",length = 250)
    private String errorCode;

    @Column(name = "error_description",length = 250)
    private String errorDescription;

    @JdbcTypeCode((SqlTypes.JSON))
    @Column(name = "refund_notes",columnDefinition = "jsonb")
    private Map<String,Object> refundNotes;

    @Column(name = "processed_at")
    private LocalDateTime processedAt;
}
