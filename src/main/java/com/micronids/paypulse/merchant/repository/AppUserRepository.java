package com.micronids.paypulse.merchant.repository;

import com.micronids.paypulse.merchant.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
}
