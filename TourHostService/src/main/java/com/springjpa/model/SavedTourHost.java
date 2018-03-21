package com.springjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tourHostSaved")
public class SavedTourHost implements Serializable{

	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@ManyToOne(targetEntity=TourHost.class)
	@JoinColumn(name="idTourHost")
    private TourHost tourHost;


	/** @ManyToOne(targetEntity=User.class)
	@JoinColumn(name="idUser")*/
    private int userID;
	
	protected SavedTourHost() {
	}
 
	public SavedTourHost(TourHost host, int user) {
		this.tourHost = host;
		this.userID = user;
	}
	
	public TourHost getTourHost() {
		return tourHost;
	}

	public void setTourHost(TourHost tourHost) {
		this.tourHost = tourHost;
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	@Override
	public String toString() {
		return String.format("SavedTourHost[tourHost=%d, userID=%d]", tourHost, userID);
	}
}
