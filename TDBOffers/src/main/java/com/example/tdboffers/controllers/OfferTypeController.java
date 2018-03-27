package com.example.tdboffers.controllers;

import com.example.tdboffers.models.OfferType;
import com.example.tdboffers.services.OfferTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/offertype")
public class OfferTypeController {

    @Autowired
    private OfferTypeService offerTypeService;

    @RequestMapping(value = "/create" ,consumes = "application/json",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public OfferType createOffer(@RequestBody OfferType data){
        return offerTypeService.createOfferType(data);
    }
}
