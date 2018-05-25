package com.springjpa.model;

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
	private int idTourHost;	

	@Column(name = "username", unique = true, nullable = false)
	private String usernameTourHost;
	
	@Column(name = "pwHash")
	private String passwordTourHost;
	
	@Column(name = "email")
	private String emailTourHost;
 
	@Column(name = "name")
	private String nameTourHost;
	
	private String role;
 
	public TourHost() {}
 
	public TourHost(String username, String pwHash, String email, String name, String role) {
		this.usernameTourHost = username;
		this.passwordTourHost = pwHash;
		this.emailTourHost = email;
		this.nameTourHost = name;
		this.role = roleTourHost;
	}
	
	public String getUsernameTourHost(){
		return usernameTourHost;
	}
	
	public void setUsernameTourHost(String username){
		this.usernameTourHost = username;
	}
	
	public String getPasswordTourHost(){
		return passwordTourHost;
	}
	
	public void setPasswordTourHost(String password){
		this.passwordTourHost = password;
	}
	
	public String getEmailTourHost(){
		return emailTourHost;
	}
	
	public void setEmailTourHost(String email){
		this.emailTourHost = email;
	}
	
	public String getNameTourHost(){
		return nameTourHost;
	}
	
	public void setNameTourHost(String name){
		this.nameTourHost = name;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
 
	@Override
	public String toString() {
		return String.format("TourHost [id = %d, username = '%s', password = '%s', email = '%s', name = '%s']", idTourHost, usernameTourHost, passwordTourHost, emailTourHost, nameTourHost);
	}
}
