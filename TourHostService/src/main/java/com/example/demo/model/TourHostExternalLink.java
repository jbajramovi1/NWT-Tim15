package com.example.demo.model;

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
@Table(name = "tourHostExternalLink")
public class TourHostExternalLink implements Serializable{

	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@ManyToOne(targetEntity=TourHost.class)
	@JoinColumn(name="idTourHost")
    private TourHost tourHost;

	@Column(name = "externalLink")
	private String externalLink;
	
	@Column(name = "linkType")
	private String externalLinkType;
	
	protected TourHostExternalLink() {
	}
 
	public TourHostExternalLink(TourHost host, String link, String type) {
		this.tourHost = host;
		this.externalLink = link;
		this.externalLinkType = type;
	}
	
	public TourHost getTourHost() {
		return tourHost;
	}

	public void setTourHost(TourHost tourHost) {
		this.tourHost = tourHost;
	}
	
	public String getExternalLink() {
		return externalLink;
	}

	public void setExternalLink(String externalLink) {
		this.externalLink = externalLink;
	}

	public String getExternalLinkType() {
		return externalLinkType;
	}

	public void setExternalLinkType(String externalLinkType) {
		this.externalLinkType = externalLinkType;
	}
	
	@Override
	public String toString() {
		return String.format("TourHostExternalLinks[tourHost=%d, externalLink='%s', externalLinkType='%s']", tourHost, externalLink, externalLinkType);
	}
}
