package com.example.TourHostAuthService.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tourHost")
public class TourHost implements Serializable {
 
	private static final long serialVersionUID = -3009157732242241606L;
	public static final String roleTourHost = "ROLE_TOURHOST";	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", updatable = false, nullable = false)
	private int id;	

	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "pwHash")
	private String password;
	
	@Column(name = "email")
	private String email;
 
	@Column(name = "name")
	private String name;
	
	private String role;
 
	public TourHost() {}
 
	public TourHost(String username, String pwHash, String email, String name, String role) {
		this.username = username;
		this.password = pwHash;
		this.email = email;
		this.name = name;
		this.role = roleTourHost;
	}
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "TourHost [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", name=" + name + ", role=" + role + "]";
	}
}
