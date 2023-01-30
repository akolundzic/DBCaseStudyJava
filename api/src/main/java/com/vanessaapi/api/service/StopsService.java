package com.vanessaapi.api.service;

import org.springframework.beans.factory.annotation.Autowired;
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
    //read Operations, find by DS100
    // public Stops getOne(Stops stops, String query){
    //     return repository.findOne(DS100:query);
    // }
}
