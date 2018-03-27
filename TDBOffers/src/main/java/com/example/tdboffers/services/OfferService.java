package com.example.tdboffers.services;

import com.example.tdboffers.models.Offer;
import com.example.tdboffers.repositories.IOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    @Autowired
    private IOfferRepository offerRepository;

    public Offer createOffer(Offer data){
        Offer offer=new Offer();
        offer.setName(data.getName());
        offer.setLanguage(data.getLanguage());
        offer.setDescription(data.getDescription());
        offer.setDuration(data.getDuration());
        offer.setOfferSeason(data.getOfferSeason());
        offer.setOfferType(data.getOfferType());
        offer.setParticipantsLimit(data.getParticipantsLimit());
        offer.setPrice(data.getPrice());

        return offerRepository.save(offer);

    }
}
