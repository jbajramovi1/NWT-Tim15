package com.example.booking.services;

import com.example.booking.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    public boolean userExists(int id) {
        try {
            User response = new RestTemplate().getForObject(
                    "http://localhost:8080/user?id={id}", User.class, id);
            return response != null && response.getIdKorisnika() != null;
        } catch (RestClientException e) {
            return false;
        }
    }
}
