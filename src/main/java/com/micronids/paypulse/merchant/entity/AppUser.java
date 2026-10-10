package com.micronids.paypulse.merchant.entity;

import com.micronids.paypulse.shared.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUser{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(length = 40,nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

}
