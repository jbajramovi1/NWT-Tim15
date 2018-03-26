package com.example.booking.models;

import javax.persistence.*;

@Entity
@Table(name="offer")
public class Offer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
