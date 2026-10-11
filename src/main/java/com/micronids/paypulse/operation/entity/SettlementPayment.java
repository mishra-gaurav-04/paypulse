package com.micronids.paypulse.operation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "settlement_payment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SettlementPayment {

    @EmbeddedId
    private SettlementPaymentId id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "settlement_id",nullable = false)
    private Settlement settlement;
}
