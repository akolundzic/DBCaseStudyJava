package com.vanessaapi.api.service;
import java.util.List;
import java.util.Optional;

import com.vanessaapi.api.model.Stops;


public interface StopsInterface  {

    String saveStops(Stops stop);
    List<Stops> getallStops();
    Optional<Stops> getOnebyId(String id);
    Optional<Stops> getOneDS(String DS);
   

    
    
}
