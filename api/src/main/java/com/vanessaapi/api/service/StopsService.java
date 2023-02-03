package com.vanessaapi.api.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.vanessaapi.api.model.Stops;
import com.vanessaapi.api.repository.StopsRepo;

@Service
public class StopsService implements StopsInterface{

    @Autowired
    private StopsRepo repo;

    @Autowired
    private MongoTemplate mt;


    @Override
    public String saveStops(Stops stop) {
        
        return repo.save(stop).get_id();
    }
    @Override
    public List<Stops> getallStops(){

        return repo.findAll();
    }
    @Override
    public Optional<Stops> getOnebyId( String id){
        Optional<Stops> obj =repo.findById(id);
        if(obj == null) {
            throw new IllegalStateException("ID not found :"+ id);
        }
        return obj;
    }
    
    @Override
    public Optional<Stops> getOneDS(String DS ){
        Query query = new Query();
        query.addCriteria(Criteria.where("DS100").is(DS));
        Stops obj = mt.findOne(query, Stops.class);
        if(obj == null) {
            throw new IllegalStateException("Stop not found");
        }
        return Optional.of(obj);
       }         
}
