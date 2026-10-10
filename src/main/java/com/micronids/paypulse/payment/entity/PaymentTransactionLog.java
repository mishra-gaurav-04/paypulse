package com.micronids.paypulse.payment.entity;

import com.micronids.paypulse.shared.enums.PaymentActor;
import com.micronids.paypulse.shared.enums.PaymentEvent;
import com.micronids.paypulse.shared.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentTransactionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "payment_id",nullable = false)
    private Payment payment;

    @Enumerated(EnumType.STRING)
    @Column(name = "from_status", length = 30,nullable = false)
    private PaymentStatus fromStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "to_status", length = 30,nullable = false)
    private PaymentStatus toStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "event", length = 30,nullable = false)
    private PaymentEvent event;

    @Enumerated(EnumType.STRING)
    @Column(name = "actor", nullable = false)
    private PaymentActor actor;

    @Column(nullable = false)
    private LocalDateTime occurredAt;

}
