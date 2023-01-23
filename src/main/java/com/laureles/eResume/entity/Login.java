package com.laureles.eResume.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "login_credential", uniqueConstraints = @UniqueConstraint(columnNames = "user_name"))
public class Login {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "Password")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "loginusers_roles",
				joinColumns = @JoinColumn(
							name = "user_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(
							name = "role_id", referencedColumnName = "id"))
	private Collection<LoginRole> roles;
	
	public Login () {
		
	}
	

	public Login(String name, String email, String userName, String password, Collection<LoginRole> roles) {
		super();
		this.name = name;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Collection<LoginRole> getRoles() {
		return roles;
	}


	public void setRoles(Collection<LoginRole> roles) {
		this.roles = roles;
	}
	

}
