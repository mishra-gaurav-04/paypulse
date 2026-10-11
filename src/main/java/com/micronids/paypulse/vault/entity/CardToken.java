package com.micronids.paypulse.vault.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "card_token")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardToken {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // TODO this token should be hashed and whenever it is going to be used some where need to decrypt it and then user
    @Column(name = "token_hash",nullable = false,length = 50,unique = true)
    private String tokenHash;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "vault_card",nullable = false)
    private VaultCard vaultCard;

    @Column(name = "customer_id",nullable = false)
    private UUID customerId;

    @Column(name = "merchant_id",nullable = false)
    private UUID merchantId;

    private LocalDateTime revokedAt;
}
