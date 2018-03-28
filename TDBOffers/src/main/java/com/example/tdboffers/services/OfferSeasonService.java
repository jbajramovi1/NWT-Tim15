package com.example.tdboffers.services;

import com.example.tdboffers.models.OfferSeason;
import com.example.tdboffers.repositories.IOfferSeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferSeasonService {
    @Autowired
    private IOfferSeasonRepository offerSeasonRepository;

    public OfferSeason createOfferSeason(OfferSeason data){
        OfferSeason offerSeason=new OfferSeason();

        offerSeason.setName(data.getName());
        return offerSeasonRepository.save(offerSeason);
    }

    public void deleteById(Integer id){
        offerSeasonRepository.deleteById(id);
    }
}
