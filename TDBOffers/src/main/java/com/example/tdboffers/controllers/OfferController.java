package com.example.tdboffers.controllers;

import com.example.tdboffers.models.Offer;
import com.example.tdboffers.services.OfferService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Field;

@Controller
@RequestMapping("/offer")
public class OfferController {
    @Autowired
    private OfferService offerService;


    @Qualifier("eurekaClient")
    @Autowired
    EurekaClient discoveryClient;
    private Field idTourHost;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/create" ,consumes = "application/json",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Object> createOffer(/*@RequestHeader("Authorization") String token, @RequestHeader("Roles") String role,*/ @RequestBody Offer data){
    	/*HttpHeaders headers = new HttpHeaders();
	    headers.set("Authorization", token);
	    headers.set("Roles", role);
	    HttpEntity<String> entity = new HttpEntity<String>(headers);
	    */
    	try {
            /*InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("ZuulAPIGateway", false);
            String url = instanceInfo.getHomePageUrl() + "/tourhost/find?user="+data.getTourHost();

            Object response = new RestTemplate().exchange(url, HttpMethod.GET, entity, Object.class, data.getTourHost());
            */
            return ResponseEntity.status(HttpStatus.OK).body(offerService.createOffer(data));
        }
        catch (HttpClientErrorException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No tour host with given id");
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Offer> getOfferById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(offerService.getById(id));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getbyhost/{host}", method = RequestMethod.GET)
    public ResponseEntity<Object> getOfferByHost(@PathVariable("host") Integer host){
        try {
            InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("tourhost-service", false);
            String url = instanceInfo.getHomePageUrl() + "/find?user="+host;

            Object response = new RestTemplate().getForObject(
                    url, Object.class, host);


            return ResponseEntity.status(HttpStatus.OK).body(offerService.getByTourHost(host));
        }
        catch (HttpClientErrorException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No tour host with given id");
        }
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<Object> getOffers(){
        return ResponseEntity.status(HttpStatus.OK).body(offerService.getAll());
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        offerService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "update/{id}", consumes = "application/json",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Offer updateOffer(@RequestBody Offer data, @PathVariable("id") Integer id){
        return offerService.updateOffer(data,id);
    }
}
