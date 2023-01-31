package com.vanessaapi.api.service;
import java.util.List;

import com.vanessaapi.api.model.Stops;

public interface StopsInterface {

    String saveStops(Stops stop);
    List<Stops> getallStops();
    
}
