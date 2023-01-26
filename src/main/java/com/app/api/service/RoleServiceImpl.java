package com.app.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.api.entity.Roles;
import com.app.api.repository.RoleRepository;

import java.util.Collection;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository repository;
	
	@Override
	@Transactional
	public Roles findById(Integer roleId) {
		return repository.findById(roleId).orElse(null);
	}

	@Override
	public Collection<Roles> findAll() {
		return repository.findAll();
	}

}
