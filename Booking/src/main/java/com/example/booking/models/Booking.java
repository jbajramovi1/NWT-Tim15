package com.example.booking.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="booking")
public class Booking {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer offerId;

    @Column
    private Date bookingDate;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}
