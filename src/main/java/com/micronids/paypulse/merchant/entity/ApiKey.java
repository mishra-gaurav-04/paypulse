package com.micronids.paypulse.merchant.entity;

import com.micronids.paypulse.shared.enums.ApiKeyEnvironment;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
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

    @Column(nullable = false,length = 50)
    private String key_id;

    @Column(nullable = false,length = 500)
    private String key_secret_hash;

    @Column(nullable = false,length = 500)
    private String webhook_secret_hash;

    @Column(nullable = false,length = 15)
    @Enumerated(EnumType.STRING)
    private ApiKeyEnvironment environment;

    @Column(nullable = false)
    private Boolean enabled = true;
    private LocalDateTime lastUsedAt;
    private LocalDateTime rotatedAt;
    private LocalDateTime grace_period_expires_at;

}
