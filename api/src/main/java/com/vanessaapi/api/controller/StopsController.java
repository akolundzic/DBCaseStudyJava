package com.vanessaapi.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    @GetMapping("/stops/{DS100}")
    public Optional<Stops> getOneStop(@PathVariable String DS100){
        return service.getOnebyDS(DS100);
    }    
}
