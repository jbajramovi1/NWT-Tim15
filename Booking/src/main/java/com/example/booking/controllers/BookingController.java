package com.example.booking.controllers;

import com.example.booking.models.Booking;
import com.example.booking.requests.BookingRequest;
import com.example.booking.services.BookingService;
import com.example.booking.services.OfferService;
import com.example.booking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class BookingController {

    private final OfferService offerService;
    private final BookingService bookingService;
    private final UserService userService;

    @Autowired
    public BookingController(BookingService bookingService, OfferService offerService, UserService userService) {
        this.bookingService = bookingService;
        this.offerService = offerService;
        this.userService = userService;
    }

    //Get all bookings
    @CrossOrigin(origins = "*")
    @RequestMapping("/booking/{id}")
    public ResponseEntity<Booking> booking(@PathVariable(value="id") Integer id) {
        Optional<Booking> bookingOptional = bookingService.findById(id);
        if (bookingOptional.isPresent()) {
            return new ResponseEntity<>(bookingOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Get booking by Id
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Booking>> booking() {
        List<Booking> bookingList = bookingService.findAll();
        return new ResponseEntity<>(bookingList, HttpStatus.OK);
    }

    //Create booking
    @CrossOrigin(origins = "*")
    @RequestMapping(path="/booking", method = RequestMethod.POST)
    public ResponseEntity<Booking> booking(@Valid @RequestBody BookingRequest request) {
        if (request.getOfferId() == null || !offerService.offerExists(request.getOfferId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (request.getUserId() == null || !userService.userExists(request.getUserId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Booking booking = new Booking();
        booking.setBookingDate(request.getBookingDate());
        booking.setUserId(request.getUserId());
        booking.setOfferId(request.getOfferId());
        bookingService.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }
}
