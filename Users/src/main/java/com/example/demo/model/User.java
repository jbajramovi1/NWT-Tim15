package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="id")
	    private Integer idKorisnika;
	    @Column
	    private String username;  
	    @Column(name="password_hash")
	    private String passwordHash;
	    @Column
	    private String email;
	    @Column
	    private String firstName;
	    @Column
	    private String lastName;
	    @Column
	    private String phoneNumber;
	    @Column
	    private char[] image;
	    @Column
	    private String country;
	    @ManyToOne(cascade = CascadeType.DETACH, targetEntity = Role.class)
	    private Role offerType;
	    
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
		public Role getOfferType() {
			return offerType;
		}
		public void setOfferType(Role offerType) {
			this.offerType = offerType;
		}	    
}
