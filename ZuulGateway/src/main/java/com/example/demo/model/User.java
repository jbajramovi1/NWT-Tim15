package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "korisnici")
public class User implements Serializable {
	public static final String roleUser = "ROLE_USER";
	private static final long serialVersionUID = 2L;
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="id", updatable = false, nullable = false)
	    private Integer id;    
	    
	    @Column(unique = true)
	    @NotNull
	    @Length(min = 3)
	    private String username;  
	    
	    @Column(name="password")
	    @NotNull
	    @Length(min = 3)
	    private String password;
	    
	    private String email;    
	    private String firstName;	    
	    private String lastName;
	    private String phoneNumber;	    
	    private char[] image;   
	    private String country;
	    private String role;
	    
	    public User() {}
	    
		public User(String username, String password, String email, String firstName, String lastName,
				String phoneNumber, char[] image, String country, String role) {
			super();
			this.username = username;
			this.password = password;
			this.email = email;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
			this.image = image;
			this.country = country;
			this.role = role;
		}
		
		public Integer getIdKorisnika() {
			return id;
		}
		public void setIdKorisnika(Integer idKorisnika) {
			this.id = idKorisnika;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPasswordHash() {
			return password;
		}
		public void setPasswordHash(String passwordHash) {
			this.password = passwordHash;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public char[] getImage() {
			return image;
		}
		public void setImage(char[] image) {
			this.image = image;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
}
