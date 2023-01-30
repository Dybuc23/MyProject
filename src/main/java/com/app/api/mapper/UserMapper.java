package com.app.api.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.app.api.entity.Users;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserMapper {
	private Long userId;
	private String username;
	private String password;
	private String name;
	private String lastname;
	private String dni;
	private String address;
	private String number;
	private String email;
	private String sex;
	private Boolean status;
	
	
	public UserMapper(Users user) {
		this(user.getUserId(),user.getUsername(),user.getPassword(),user.getName(),user.getLastname(),
				user.getDni(),user.getAddress(), user.getNumber(), user.getEmail(), user.getSex(), user.isStatus());
	}
	
}
