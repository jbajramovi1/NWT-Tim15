package com.example.tdboffers.controllers;

import com.example.tdboffers.models.OfferType;
import com.example.tdboffers.services.OfferTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<OfferType> getOfferTypeById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(offerTypeService.getById(id));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<Object> getOfferType(){
        return ResponseEntity.status(HttpStatus.OK).body(offerTypeService.getAll());
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        offerTypeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @RequestMapping(value = "update/{id}", consumes = "application/json",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public OfferType updateOfferSeason(@RequestBody OfferType data, @PathVariable("id") Integer id){
        return offerTypeService.updateOfferType(data,id);
    }

}
