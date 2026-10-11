package com.micronids.paypulse.operation.entity;

import com.micronids.paypulse.shared.enums.WebhookEventStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "webhook_event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebhookEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false,name = "merchant_id")
    private UUID merchantId;

    @Column(nullable = false,name = "event_type")
    private String eventType;

    @JdbcTypeCode((SqlTypes.JSON))
    @Column(name = "payload",columnDefinition = "jsonb")
    private Map<String,Object> payload;

    @Column(name = "target_url",nullable = false)
    private String targetUrl;

    @Column(name = "signature", nullable = false)
    private String signature;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",length = 20,nullable = false)
    private WebhookEventStatus status;

    @Column(nullable = false)
    private Integer attempts;

    @Column(name = "last_response_code",nullable = false)
    private Integer lastResponseCode;

    private LocalDateTime nextRetryAt;

    private LocalDateTime lastRetryAt;

    private String lastResponseBody;

    private LocalDateTime deliveredAt;
}
