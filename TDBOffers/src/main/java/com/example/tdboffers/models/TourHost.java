package com.example.tdboffers.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
@Table(name="tour_host")
public class TourHost {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="idHost")
    private Integer idHost;

    @Column(name="username")
    private String username;

    @Override
    public String toString() {
        return "User [idHost=" + idHost + ", username=" + username + "]";
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdHost() {
        return idHost;
    }

    public void setIdHost(Integer idHost) {
        this.idHost = idHost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TourHost(Integer idHost, String username) {
        super();
        this.idHost=idHost;
        this.username = username;
    }

    public TourHost() {
        super();
    }
}