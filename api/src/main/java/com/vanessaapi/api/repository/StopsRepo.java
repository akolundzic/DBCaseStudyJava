package com.vanessaapi.api.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vanessaapi.api.model.Stops;

@Repository
public interface StopsRepo extends MongoRepository<Stops,String> {


    
}
