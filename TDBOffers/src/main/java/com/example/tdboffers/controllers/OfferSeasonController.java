package com.example.tdboffers.controllers;

import com.example.tdboffers.models.OfferSeason;
import com.example.tdboffers.services.OfferSeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/offerseason")
public class OfferSeasonController {

    @Autowired
    private OfferSeasonService offerSeasonService;

    @RequestMapping(value = "/create" ,consumes = "application/json",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public OfferSeason createOffer(@RequestBody OfferSeason data){
        return offerSeasonService.createOfferSeason(data);
    }
}
