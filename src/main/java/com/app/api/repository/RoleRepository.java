package com.app.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.api.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles,Integer>{

}
