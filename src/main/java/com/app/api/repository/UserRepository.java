package com.app.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.app.api.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	//@Query(value="select * from users where username=?1",nativeQuery=true)
	public abstract Users findByUsername(String username);
}
