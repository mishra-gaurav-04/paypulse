package com.micronids.paypulse.payment.entity;

import com.micronids.paypulse.merchant.entity.Merchant;
import com.micronids.paypulse.shared.entityObjects.Money;
import com.micronids.paypulse.shared.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false,name = "merchant_id")
    private UUID merchant_id;
    private String idempotency_key;

    @Embedded
    private Money amount;

    @Column(nullable = false,length = 20)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.CREATED;

    @Column(nullable = false)
    private Integer attempts = 0;

    @JdbcTypeCode((SqlTypes.JSON))
    @Column(columnDefinition="jsonb")
    private Map<String,Object> notes;

    @Column(nullable = false,name = "expires_at")
    private LocalDateTime expiredAt;
}
