package com.micronids.paypulse.merchant.entity;

import com.micronids.paypulse.shared.enums.ApiKeyEnvironment;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "api_key")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "merchant_id",nullable = false)
    private Merchant merchant;

    @Column(nullable = false,length = 50,name = "key_id")
    private String keyId;

    @Column(nullable = false,length = 500,name = "key_secret_hash")
    private String keySecretHash;

    @Column(nullable = false,length = 500,name = "webhook_secret_hash")
    private String webhookScretHash;

    @Column(nullable = false,length = 15)
    @Enumerated(EnumType.STRING)
    private ApiKeyEnvironment environment;

    @Column(nullable = false)
    private Boolean enabled = true;
    private LocalDateTime lastUsedAt;
    private LocalDateTime rotatedAt;

    @Column(name = "grace_period_expires_at",nullable = false)
    private LocalDateTime gracePeriodExpiresAt;

}
