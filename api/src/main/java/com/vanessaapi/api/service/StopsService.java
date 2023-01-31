package com.vanessaapi.api.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import com.vanessaapi.api.model.Stops;
import com.vanessaapi.api.repository.StopsRepo;

@Service
public class StopsService implements StopsInterface{

    @Autowired
    private StopsRepo repo;

    @Override
    public String saveStops(Stops stop) {
        
        return repo.save(stop).get_id();
    }

    public List<Stops> getallStops(){

        return repo.findAll();
    }
    @Query("{'DS100' : ?0}")
    public Optional<Stops> getOnebyDS( String DS100){
       
        return repo.findById(DS100);
    }
    
}
