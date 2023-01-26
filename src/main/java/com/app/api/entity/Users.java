package com.app.api.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class Users implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
	
    @Column(unique = true, nullable = false)
	private String username;
    
    @Column(nullable=false)
	private String password;
    
    @Column(name="nameuser")
    private String name;
    
    @Column(name="lastnameuser")
    private String lastname;
    
    @Column(name="dniuser")
    private String dni;
    
    @Column(name="addressuser")
    private String address;
    
    @Column(name="numberuser")
    private String number;
    
    @Column(name="emailuser")
    private String email;
    
    @Column(name="sexuser")
    private String sex;
    
    @Column(name="status_user")
    private boolean status;
    
    @ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="users_roles",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Roles> itemsRole=new HashSet<>();

    @OneToMany(mappedBy = "portfolio")
    private Collection<Client> itemsClient = new ArrayList<>();

    public void addRole(Roles role) {
        this.itemsRole.add(role);
    }
}
