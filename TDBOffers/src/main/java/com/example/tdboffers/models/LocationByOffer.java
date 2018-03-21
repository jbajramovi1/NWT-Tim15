package com.example.tdboffers.models;

import javax.persistence.*;

@Entity
@Table(name="location_by_offer")
public class LocationByOffer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @ManyToOne(cascade = CascadeType.DETACH, targetEntity = Offer.class)
    private Offer offer;
    @ManyToOne(cascade = CascadeType.DETACH, targetEntity = Location.class)
    private Location location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
