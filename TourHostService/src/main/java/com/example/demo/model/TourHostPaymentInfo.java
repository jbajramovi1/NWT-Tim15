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
@Table(name = "tourHostPaymentInfo")
public class TourHostPaymentInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@OneToOne(targetEntity=TourHost.class)
	@JoinColumn(name="idTourHost")
    private TourHost tourHost;
 
	@Column(name = "swift")
	private String swiftTourHost;
	
	@Column(name = "iban")
	private String ibanTourHost;
	
	
	protected TourHostPaymentInfo() {
	}
 
	public TourHostPaymentInfo(TourHost host, String swift, String iban) {
		this.tourHost = host;
		this.swiftTourHost = swift;
		this.ibanTourHost = iban;
	}
	
	public TourHost getTourHost() {
		return tourHost;
	}

	public void setTourHost(TourHost tourHost) {
		this.tourHost = tourHost;
	}
	
	public String getSwiftTourHost(){
		return swiftTourHost;
	}
	
	public void setSwiftTourHost(String swift){
		this.swiftTourHost = swift;
	}
	
	public String getIbanTourHost(){
		return ibanTourHost;
	}
	
	public void setIbanTourHost(String iban){
		this.ibanTourHost = iban;
	}
	
	@Override
	public String toString() {
		return String.format("TourHostPaymentInfo[tourHost=%d, SWIFT='%s', IBAN='%s']", tourHost, swiftTourHost, ibanTourHost);
	}
}
