package com.springjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tour")
public class Tour {
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="id")
	    private Integer id;
	    
	    @Column(name="idTour")
	    private Integer idTour;	    
	    
	    @Column(name="idTourHost")
	    private Integer idTourHost;
	    
	    @Column(name="name")
	    private String name;

		public Integer getIdTourHost() {
			return idTourHost;
		}

		public void setIdTourHost(Integer idTourHost) {
			this.idTourHost = idTourHost;
		}

		public Integer getIdTour() {
			return idTour;
		}

		public void setIdTou(Integer idTour) {
			this.idTour = idTour;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Tour [id=" + id + ", idTour=" + idTour + ", name=" + name + ", idTourHost=" + idTourHost + "]";
		}
		
		public Tour(Integer idTour, String name, Integer idTourHost) {
			super();
			this.idTour = idTour;
			this.name = name;
			this.idTourHost = idTourHost;
		}
		
		public Tour() {
			super();			
		}	   
	    
}
