package com.example.tdboffers.services;

import com.example.tdboffers.models.OfferSeason;
import com.example.tdboffers.repositories.IOfferSeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferSeasonService {
    @Autowired
    private IOfferSeasonRepository offerSeasonRepository;

    public OfferSeason createOfferSeason(OfferSeason data){
        OfferSeason offerSeason=new OfferSeason();

        offerSeason.setName(data.getName());
        return offerSeasonRepository.save(offerSeason);
    }

    public OfferSeason getById(Integer id) {return offerSeasonRepository.getOfferSeasonById(id);}

    public List<OfferSeason> getAll() {return offerSeasonRepository.findAll();}

    public void deleteById(Integer id){
        offerSeasonRepository.deleteById(id);
    }

    public OfferSeason updateOfferSeason(OfferSeason data, Integer id){
        OfferSeason offerSeason=getById(id);
        if (data.getName()!=null) offerSeason.setName(data.getName());
        return offerSeasonRepository.save(offerSeason);
    }
}
