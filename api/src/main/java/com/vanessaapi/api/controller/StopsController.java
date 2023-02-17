package com.vanessaapi.api.controller;
import com.vanessaapi.api.middleware.ApiError;
import java.util.Optional;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanessaapi.api.model.Stops;
import com.vanessaapi.api.service.StopsInterface;
import jakarta.validation.constraints.NotBlank;


@RestController
@RequestMapping("/")
@Validated
public class StopsController {

    @Autowired
    private StopsInterface service;

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
    
    @GetMapping("/distance/{DS1}")
    public Optional<Stops> getDS( @NotBlank @PathVariable("DS1") String DS1){
       
        String detail = "No Stops found for "+DS1;
        String type ="/distance/"+DS1;
        String title ="Ther was no stop found in the data";
        var dt = new ApiError("Ther is no Stop for"+DS1, detail, type, title);
        
        return service.getOneDS(DS1, dt);
       
       }
  
    
            
    
    
    
}
