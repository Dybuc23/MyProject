package com.app.api.repository;

import com.app.api.entity.BusinessKind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<BusinessKind,Integer> {
}
