package com.springjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
@Table(name="system_user")
public class User {
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="id")
	    private Integer id;
	    
	    @Column(name="idUser")
	    private Integer idKorisnika;
	    
	    @Column(name="username")
	    private String username;

		@Override
		public String toString() {
			return "User [idKorisnika=" + idKorisnika + ", username=" + username + "]";
		}

		public Integer getIdUser() {
			return idKorisnika;
		}

		public void setIdUser(Integer idUser) {
			this.idKorisnika = idUser;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public User(Integer idUser, String username) {
			super();
			this.idKorisnika = idUser;
			this.username = username;
		}

		public User() {
			super();			
		} 	    	    
}
