package com.vanessaapi.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;
import org.springframework.stereotype.Service;

import com.vanessaapi.api.model.Stops;
import com.vanessaapi.api.repository.StopsRepository;

@Service
public class StopsService {

    @Autowired
    private StopsRepository repository;

    //CRUD Operations
    //save
    public Stops addStation(Stops stops){

        return repository.save(stops);
    }
    //read Operations,
    //Find all
    public List<Stops> getAll(){

        return repository.findAll();
    }
    // find by DS100
    public Stops getOnebyDS( String DS100){

         return repository.findById(DS100)
         .orElseThrow(()-> new RuntimeException(String.format("Stop %s not found",DS100)));
    }
    // get one by Id
    public Stops getOnebyId(String Idin){
        return repository.findById(Idin).get();
    }
    //update
    public Stops updateStops(Stops stop ){
        //get existing doc from db
        //populate from request ot ex. entity
        return repository.findById(stop.get_id()).get();

    }
    //delete 
    public String deleteStop(String Id){
        repository.deleteById(Id);
        return "Stop deleted";
    }
}