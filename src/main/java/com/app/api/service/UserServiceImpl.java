package com.app.api.service;

import java.util.Collection;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.api.entity.Roles;
import com.app.api.entity.Users;
import com.app.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService,UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	@Transactional
	public void insert(Users user) 
	{
		PasswordEncoder password=new BCryptPasswordEncoder();
		String passwordCifrado=password.encode(user.getPassword());
			
		user.setPassword(passwordCifrado);
			
		repository.save(user);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Users findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Users userDB=findByUsername(username);
		
		Collection<GrantedAuthority> roles=new ArrayList<>();
		
		for(Roles role:userDB.getItemsRole()) {
			roles.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
		}
		
		if(userDB!=null)
		{			
			User user=new User(username,userDB.getPassword(),roles);
			return user;
		}
		
		throw new UsernameNotFoundException("¡Username no existe!");
	}

	@Override
	public Collection<Users> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void update(Users user) {
		repository.save(user);
	}

	//@Override
	/*public void delete(Integer userId) {
		repository.deleteById(userId);
	}*/

	@Override
	public Users findById(Integer userId) {
		return repository.findById(userId).orElse(null);
	}

}
