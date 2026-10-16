package com.micronids.paypulse.merchant.repository;

import com.micronids.paypulse.merchant.entity.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApiKeyRepository extends JpaRepository<ApiKey, UUID> {
}
