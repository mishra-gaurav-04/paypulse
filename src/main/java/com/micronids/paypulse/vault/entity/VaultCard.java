package com.micronids.paypulse.vault.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "vault_card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VaultCard {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "last_four",nullable = false,length = 10)
    private String lastFour;

    @Column(nullable = false,length = 6)
    private String bin;

    @Column(nullable = false)
    private byte[] encryptedPan;

    @Column(nullable = false)
    private byte[] encryptedDek;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false,name = "expiry_month")
    private String expiryMonth;

    @Column(nullable = false,name = "card_holder_name")
    private String cardHolderName;

    private LocalDateTime deletedAt;

}
