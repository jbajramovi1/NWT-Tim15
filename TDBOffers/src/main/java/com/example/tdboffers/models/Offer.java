package com.example.tdboffers.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="offer")
public class Offer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column
    @NotNull
    @Size(max = 100)
    private String name;
    @Column
    private String language;
    @Column (name="participants_limit")
    @Min(1)
    private Integer participantsLimit;
    @Column
    private String description;
    @Column
    @Min(0L)
    private Double price;
    @Column
    @Min(0)
    private Integer duration; //in hours
    @ManyToOne(cascade = CascadeType.DETACH, targetEntity = OfferType.class)
    private OfferType offerType;
    @ManyToOne(cascade = CascadeType.DETACH, targetEntity = OfferSeason.class)
    private OfferSeason offerSeason;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity=TourHost.class)
    @JoinColumn(name="tour_host")
    private TourHost tourHost;

    public Offer(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getParticipantsLimit() {
        return participantsLimit;
    }

    public void setParticipantsLimit(Integer participantsLimit) {
        this.participantsLimit = participantsLimit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferType offerType) {
        this.offerType = offerType;
    }

    public OfferSeason getOfferSeason() {
        return offerSeason;
    }

    public void setOfferSeason(OfferSeason offerSeason) {
        this.offerSeason = offerSeason;
    }

    public TourHost getTourHost() {
        return tourHost;
    }

    public void setTourHost(TourHost tourHost) {
        this.tourHost = tourHost;
    }
}
