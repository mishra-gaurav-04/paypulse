package com.micronids.paypulse.operation.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "dlq_event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DlqEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "merchant_id",nullable = false)
    private UUID merchantId;

    @OneToOne(fetch = FetchType.LAZY)
    private WebhookEvent webhookEvent;

    @Column()
    private String finalError;

    @JdbcTypeCode((SqlTypes.JSON))
    @Column(name = "payload",nullable = false,columnDefinition = "jsonb")
    private Map<String,Object> payload;

    private LocalDateTime movedAt;

    private LocalDateTime replayedAt;
}
