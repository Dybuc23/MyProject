package com.app.api.repository;

import com.app.api.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
