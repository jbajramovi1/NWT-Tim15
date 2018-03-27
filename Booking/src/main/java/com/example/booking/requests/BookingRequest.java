package com.example.booking.requests;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class BookingRequest {
    @NotNull
    private Date bookingDate;
    @NotNull
    private Integer userId;
    @NotNull
    private Integer offerId;

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
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
}
