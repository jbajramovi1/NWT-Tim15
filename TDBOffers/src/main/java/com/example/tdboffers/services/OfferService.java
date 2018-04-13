package com.example.tdboffers.services;

import com.example.tdboffers.models.Offer;
import com.example.tdboffers.repositories.IOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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
        offer.setTourHost(data.getTourHost());
        return offerRepository.save(offer);
    }

    public Offer getById(Integer id){
        return offerRepository.getOfferById(id);
    }

    public List<Offer> getByTourHost(Integer host) {
        return offerRepository.getOfferByTourHost(host); }

    public List<Offer> getAll(){
        return offerRepository.findAll();
    }

    public void deleteById(Integer id){
       offerRepository.deleteById(Integer.valueOf(id));
    }

    public Offer updateOffer(Offer data,Integer id){
        Offer offer=getById(id);
        if (data.getName()!=null) offer.setName(data.getName());
        if (data.getLanguage()!=null) offer.setLanguage(data.getLanguage());
        if (data.getDescription()!=null) offer.setDescription(data.getDescription());
        if (data.getDuration()!=null) offer.setDuration(data.getDuration());
        if (data.getOfferSeason()!=null) offer.setOfferSeason(data.getOfferSeason());
        if (data.getOfferType()!=null) offer.setOfferType(data.getOfferType());
        if (data.getParticipantsLimit()!=null) offer.setParticipantsLimit(data.getParticipantsLimit());
        if (data.getPrice()!=null) offer.setPrice(data.getPrice());
        if (data.getTourHost()!=null) offer.setTourHost(data.getTourHost());
        return offerRepository.save(offer);
    }
}
