package com.example.tdboffers.services;

import com.example.tdboffers.models.OfferType;
import com.example.tdboffers.repositories.IOfferTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferTypeService {

    @Autowired
    private IOfferTypeRepository offerTypeRepository;

    public OfferType createOfferType(OfferType data){
        OfferType offerType=new OfferType();

        offerType.setName(data.getName());
        offerType.setImage(data.getImage());

        return offerTypeRepository.save(offerType);
    }
}
