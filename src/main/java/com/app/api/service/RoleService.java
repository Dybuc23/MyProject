package com.app.api.service;

import com.app.api.entity.Roles;
import com.app.api.entity.Users;

import java.util.Collection;

public interface RoleService {
	public abstract Roles findById(Integer roleId);
	public abstract Collection<Roles> findAll();
}
