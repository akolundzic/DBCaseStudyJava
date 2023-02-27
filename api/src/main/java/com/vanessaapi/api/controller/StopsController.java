package com.vanessaapi.api.controller;
import com.vanessaapi.api.exceptions.StopNotFound;
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
import org.springframework.http.ResponseEntity;
import com.vanessaapi.api.model.Stops;
import com.vanessaapi.api.service.StopsInterface;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("api/v1")
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
    public Optional<Stops> getDS(@NotBlank @PathVariable String DS1){
        String message = "No data for endpoint "+DS1+" found";
        try{return service.getOneDS(DS1);}
        catch(StopNotFound e){
            throw new StopNotFound(message);
        }
       }
    @GetMapping("/distance/{DS1}/{DS2}")
    public ResponseEntity<?> getTwoStops(@NotBlank @PathVariable String DS1,
     @NotBlank @PathVariable String DS2){

        return ResponseEntity.ok(service.getTwoStops(DS1,DS2));
     }
    
    
            
    
    
    
}
