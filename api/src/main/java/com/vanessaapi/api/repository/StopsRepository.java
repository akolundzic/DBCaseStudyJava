package com.vanessaapi.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.vanessaapi.api.model.Stops;

public interface StopsRepository extends MongoRepository <Stops,String>{
    
   //create
    Stops addStation(Stops stops);
   //read
    @Query("{DS100:'?0'}")
    Stops getOnebyDS(String query);
}
