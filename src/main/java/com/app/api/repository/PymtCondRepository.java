package com.app.api.repository;

import com.app.api.entity.PaymentCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PymtCondRepository extends JpaRepository<PaymentCondition,Integer> {
}
