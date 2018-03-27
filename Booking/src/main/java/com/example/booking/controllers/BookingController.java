package com.example.booking.controllers;

import com.example.booking.models.Offer;
import com.example.booking.models.User;
import com.example.booking.repositories.OfferRepository;
import com.example.booking.repositories.UserRepository;
import com.example.booking.models.Booking;
import com.example.booking.repositories.BookingRepository;
import com.example.booking.requests.BookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
public class BookingController {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final OfferRepository offerRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository,  UserRepository userRepository,  OfferRepository offerRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository =  userRepository;
        this.offerRepository = offerRepository;
    }

    //Get all bookings
    @RequestMapping("/booking/{id}")
    public ResponseEntity<Booking> booking(@PathVariable(value="id") Integer id) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            return new ResponseEntity<>(bookingOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Get booking by Id
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Booking>> booking() {
        List<Booking> bookingList = bookingRepository.findAll();
        return new ResponseEntity<>(bookingList, HttpStatus.OK);
    }

    //Create booking
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Booking> booking(@Valid @RequestBody BookingRequest request) {
        Optional<Offer> offer = offerRepository.findById(request.getOfferId());
        if (!offer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<User> user = userRepository.findById(request.getUserId());
        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Booking booking = new Booking();
        booking.setBookingDate(request.getBookingDate());
        booking.setUser(user.get());
        booking.setOffer(offer.get());
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }
}
