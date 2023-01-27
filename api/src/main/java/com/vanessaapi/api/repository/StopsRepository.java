package com.vanessaapi.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.vanessaapi.api.model.Stops;

public interface StopsRepository extends MongoRepository <Stops,String>{
    
}
