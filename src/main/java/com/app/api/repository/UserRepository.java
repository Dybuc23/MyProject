package com.app.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.app.api.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	//@Query(value="select * from users where username=?1",nativeQuery=true)
	public abstract Users findByUsername(String username);

	public abstract Users findOneByEmailIgnoreCaseAndPassword(String email, String password);
}
