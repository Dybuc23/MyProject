package com.app.api.service;

import java.util.Collection;

import com.app.api.entity.Users;

public interface UserService {
	public abstract void insert(Users user);
	public abstract void update(Users user);
	//public abstract void delete(Integer userId);
	public abstract Users findById(Integer userId);
	public abstract Users findByUsername(String username);
	public abstract Collection<Users> findAll();
}
