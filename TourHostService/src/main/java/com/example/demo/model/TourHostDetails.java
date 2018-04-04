package com.example.demo.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tourHostDetails")
public class TourHostDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@OneToOne(targetEntity=TourHost.class)
	@JoinColumn(name="idTourHost")
    private TourHost tourHost;
 
	@Column(name = "website")
	private String websiteTourHost;
	
	@Column(name = "workingHours")
	private String workingHours;
	
	@Column(name = "descriptionTourHost")
	private char[] descriptionTourHost;
	
	@Column(name = "contactNumberTourHost")
	private String contactNumber;
	
		protected TourHostDetails() {
	}
 
	public TourHostDetails(TourHost tourHost, String websiteTourHost, String workingHours, char[] descriptionTourHost,
				String contactNumber) {
		super();
		this.tourHost = tourHost;
		this.websiteTourHost = websiteTourHost;
		this.workingHours = workingHours;
		this.descriptionTourHost = descriptionTourHost;
		this.contactNumber = contactNumber;
	}	
	
	public TourHost getTourHost() {
		return tourHost;
	}

	public void setTourHost(TourHost tourHost) {
		this.tourHost = tourHost;
	}
	

	public String getWebsiteTourHost() {
		return websiteTourHost;
	}

	public void setWebsiteTourHost(String websiteTourHost) {
		this.websiteTourHost = websiteTourHost;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	public char[] getDescriptionTourHost() {
		return descriptionTourHost;
	}

	public void setDescriptionTourHost(char[] descriptionTourHost) {
		this.descriptionTourHost = descriptionTourHost;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "TourHostDetails [tourHost=" + tourHost + ", websiteTourHost=" + websiteTourHost + ", workingHours="
				+ workingHours + ", descriptionTourHost=" + Arrays.toString(descriptionTourHost) + ", contactNumber="
				+ contactNumber + "]";
	}
}