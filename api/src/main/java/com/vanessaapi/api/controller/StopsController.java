package com.vanessaapi.api.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vanessaapi.api.model.Stops;
import com.vanessaapi.api.service.StopsInterface;


@RestController
@RequestMapping("/")
public class StopsController {

    @Autowired
    private StopsInterface service;


    @GetMapping("/{DS100}")
    public String testEndpoint(@PathVariable String DS100){
        
        return "DS100: "+DS100;
    }
    @GetMapping("/")
    public String welcome(){
        return "Welcome to the DB Test API ";
    }
    //post
    @PostMapping
    public String saveStops(@RequestBody Stops stop){

        return service.saveStops(stop);    

    }
    @GetMapping("/stops")
    public List <Stops> getStations(){

        return service.getallStops();
    }
    @GetMapping("/stops/{id}")
    public Optional<Stops> getOne(@PathVariable String id){

        return service.getOnebyId(id);
    }    
    @GetMapping("/stops/{DS100}")
    public Stops getDS(@PathVariable String DS100 ){
        Query query = new Query();
        query.addCriteria(Criteria.where("DS100").is(DS100));
        return service.find(query,Stops.class);
        
    }
    
}
