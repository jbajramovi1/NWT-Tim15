package com.example.tdboffers.services;

import com.example.tdboffers.models.OfferType;
import com.example.tdboffers.repositories.IOfferTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public OfferType getById(Integer id) {return offerTypeRepository.getOfferTypeById(id);}

    public List<OfferType> getAll() {return offerTypeRepository.findAll();}

    public void deleteById(Integer id){
        offerTypeRepository.deleteById(id);
    }

    public OfferType updateOfferType(OfferType data, Integer id){
        OfferType offerType=getById(id);
        if (data.getName()!=null) offerType.setName(data.getName());
        if (data.getImage()!=null) offerType.setImage(data.getImage());

        return offerTypeRepository.save(offerType);
    }
}
