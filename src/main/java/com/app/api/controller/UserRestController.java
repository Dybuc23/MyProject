package com.app.api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.app.api.entity.Users;
import com.app.api.mapper.UserMapper;
import com.app.api.service.UserService;
import com.app.api.util.UtilMapper;

@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	private UserService userService;

	public UserRestController() {		
	}
	@PostMapping("/login")
	public ResponseEntity login(@RequestHeader Users users){
		users.getUsername();
		users.getPassword();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/list")
	public ResponseEntity<?> list_GET()
	{
		Collection<Users> collection = userService.findAll();
		Collection<UserMapper> collectionMapper=UtilMapper.toUser(collection);
		
		if(collectionMapper.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(collectionMapper,HttpStatus.OK);
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register_POST(@RequestBody Users user)
	{
		userService.insert(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/edit/{userId}")
	public ResponseEntity<?> edit_PUT(@RequestBody Users userEdit,@PathVariable Long userId)
	{
		Users userDb=userService.findById(userId);
		// Para actualizar y encriptar...
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hash = passwordEncoder.encode(userEdit.getPassword());
		
		if(userDb!=null)
		{
			userDb.setUsername(userEdit.getUsername());
			userDb.setName(userEdit.getName());
			userDb.setLastname(userEdit.getLastname());
			userDb.setNumber(userEdit.getNumber());
			userDb.setPassword(hash);
			userDb.setDni(userEdit.getDni());
			userDb.setSex(userEdit.getSex());
			userDb.setEmail(userEdit.getEmail());
			userService.update(userDb);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/anull/{userId}")
	public ResponseEntity<?> anull_PUT(@PathVariable Long userId,@RequestBody Users userEdit)
	{
		Users userDb=userService.findById(userId);
		
		if(userDb!=null)
		{
			userDb.setStatus(userEdit.isStatus());
			userService.update(userDb);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/search/{userId}")
	public ResponseEntity<?> search_GET(@PathVariable Long userId)
	{
		Users userDb=userService.findById(userId);
		
		if(userDb!=null) {
			UserMapper mapper = new UserMapper(userDb);
			
			return new ResponseEntity<>(mapper,HttpStatus.FOUND);
		}
		
		return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
	}
}
