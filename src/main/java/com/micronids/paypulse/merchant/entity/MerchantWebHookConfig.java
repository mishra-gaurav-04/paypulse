package com.micronids.paypulse.merchant.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "merchant_webhook_config")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MerchantWebHookConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "merchant_id",nullable = false)
    private Merchant merchant;

    @Column(name = "target_url",length = 700)
    private String targetUrl;

    @Column(name = "event_types",length = 700)
    private String eventTypes;

    @Column(nullable = false)
    private Boolean enabled = true;

    @Column(length = 300,name = "webhook_secret_hash")
    private String webhookSecretHash;
}
