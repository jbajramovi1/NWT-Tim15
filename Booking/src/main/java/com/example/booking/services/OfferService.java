package com.example.booking.services;

import com.example.booking.models.Offer;
import com.example.booking.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class OfferService {
    public boolean offerExists(int id) {
        try {
            Offer response = new RestTemplate().getForObject(
                    "http://localhost:8060/offer?id={id}", Offer.class, id);
            return response != null && response.getId() != null;
        } catch (RestClientException e) {
            return false;
        }
    }
}
