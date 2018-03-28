package com.springjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springjpa.MD5;

@Entity
@Table(name = "useri")
public class User implements Serializable {
	private static final long serialVersionUID = 2L;
	 
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="id")
	    private Integer idKorisnika;    
	    private String username;  
	    
	    @Column(name="password_hash")
	    private String passwordHash;
	    
	    private String email;    
	    private String firstName;	    
	    private String lastName;
	    private String phoneNumber;	    
	    private char[] image;   
	    private String country;
	    
	    public User() {}
	    
		public User(String username, String password, String email, String firstName, String lastName,
				String phoneNumber, char[] image, String country) {
			super();
			validateUser(username, password, email, firstName, lastName, phoneNumber, image, country);
			this.username = username;
			this.passwordHash = MD5.toHexString(MD5.computeMD5(password.getBytes()));
			this.email = email;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
			this.image = image;
			this.country = country;
		}
		public Integer getIdKorisnika() {
			return idKorisnika;
		}
		public void setIdKorisnika(Integer idKorisnika) {
			this.idKorisnika = idKorisnika;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPasswordHash() {
			return passwordHash;
		}
		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
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
		
		private boolean validateUser(String username, String passwordHash, String email, String firstName, String lastName,
				String phoneNumber, char[] image, String country) {
			String message = "";
			String usernamePattern = "^(?!\\s*$).+\n";
			String passwordPattern = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$\n";
			
			if (username.matches(usernamePattern)) message = "Username must not be empty or containing only blank spaces";
			else if (passwordHash.toString().matches(passwordPattern)) message = "Password must be at least 8 character long, have one upper and lower case letter and al least one number";
			else if (firstName.matches(usernamePattern)) message = "First name must not be empty or containing only blank spaces";
			else if (lastName.matches(usernamePattern)) message = "Last name must not be empty or containing only blank spaces";
			
			if (message.equals(""))
		return true;
		else throw new IllegalArgumentException(message);
		}
}
