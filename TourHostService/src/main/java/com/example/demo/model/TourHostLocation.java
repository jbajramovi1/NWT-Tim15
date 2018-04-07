package com.example.demo.model;

import java.io.Serializable;

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
public class TourHostLocation implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@OneToOne(targetEntity=TourHost.class)
	@JoinColumn(name="idTourHost")
    private TourHost tourHost;
	
	@Column(name = "longitude")
	private String longitudeTourHost;
	
	@Column(name = "latitude")
	private String latitudeTourHost;
 
	@Column(name = "address")
	private String addressTourHost;
	
	@Column(name = "city")
	private String cityTourHost;
	
	@Column(name = "zipCode")
	private String zipCodeTourHost;
	
	protected TourHostLocation() {
	}
		
	public TourHostLocation(TourHost tourHost, String longitudeTourHost, String latitudeTourHost,
			String addressTourHost, String cityTourHost, String zipCodeTourHost) {
		super();
		this.tourHost = tourHost;
		this.longitudeTourHost = longitudeTourHost;
		this.latitudeTourHost = latitudeTourHost;
		this.addressTourHost = addressTourHost;
		this.cityTourHost = cityTourHost;
		this.zipCodeTourHost = zipCodeTourHost;
	}

	public TourHost getTourHost() {
		return tourHost;
	}

	public void setTourHost(TourHost tourHost) {
		this.tourHost = tourHost;
	}

	public String getLongitudeTourHost() {
		return longitudeTourHost;
	}

	public void setLongitudeTourHost(String longitudeTourHost) {
		this.longitudeTourHost = longitudeTourHost;
	}

	public String getLatitudeTourHost() {
		return latitudeTourHost;
	}

	public void setLatitudeTourHost(String latitudeTourHost) {
		this.latitudeTourHost = latitudeTourHost;
	}

	public String getAddressTourHost() {
		return addressTourHost;
	}

	public void setAddressTourHost(String addressTourHost) {
		this.addressTourHost = addressTourHost;
	}

	public String getCityTourHost() {
		return cityTourHost;
	}

	public void setCityTourHost(String cityTourHost) {
		this.cityTourHost = cityTourHost;
	}

	public String getZipCodeTourHost() {
		return zipCodeTourHost;
	}

	public void setZipCodeTourHost(String zipCodeTourHost) {
		this.zipCodeTourHost = zipCodeTourHost;
	}

	@Override
	public String toString() {
		return "TourHostLocation [tourHost=" + tourHost + ", longitudeTourHost=" + longitudeTourHost
				+ ", latitudeTourHost=" + latitudeTourHost + ", addressTourHost=" + addressTourHost + ", cityTourHost="
				+ cityTourHost + ", zipCodeTourHost=" + zipCodeTourHost + "]";
	}
}
