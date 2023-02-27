package com.vanessaapi.api.service;
import com.vanessaapi.api.middleware.Haversine;
import com.vanessaapi.api.middleware.HelperFunctions;
import java.util.List;
import java.util.Optional;
import java.lang.String;
import java.util.Map;
// import com.vanessaapi.api.middleware.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.vanessaapi.api.model.Stops;
import com.vanessaapi.api.repository.StopsRepo;
import com.vanessaapi.api.exceptions.StopNotFound;

@Service
public class StopsService implements StopsInterface{

    final String keyname ="DS100";

    @Autowired
    private StopsRepo repo;

    @Autowired
    private MongoTemplate mt;

    @Override
    public String saveStops(Stops stop) {return repo.save(stop).get_id();}

    @Override
    public List<Stops> getallStops(){return repo.findAll();}

    @Override
    public Optional<Stops> getOnebyId( String id){
        Optional<Stops> obj =repo.findById(id);
        if(obj == null) {
            throw new IllegalStateException("ID not found :"+ id);
        }
        return obj;
    }
    
    @Override
    public Optional<Stops> getOneDS(String DS){
        Query query = new Query();
        query.addCriteria(Criteria.where("DS100").is(DS));
        
        try{
            Stops obj = mt.findOne(query, Stops.class);
            return Optional.of(obj);
        }
        catch(Exception e){
            throw new StopNotFound("No stop found with DS100 :"+ DS);
        }
       }  
    @Override
    public Map<String,Object> getTwoStops(String DS1, String DS2){
        Query query1 = new Query();
        Query query2 = new Query();
        query1.addCriteria(Criteria.where(keyname).is(DS1));
        query2.addCriteria(Criteria.where(keyname).is(DS2));
        var help = new HelperFunctions();
        
        try{
            Stops stop1 = mt.findOne(query1, Stops.class);
            Stops stop2 = mt.findOne(query2, Stops.class);
           
            double lat1 = help.convert(stop1.getBreite());
            double lat2 =  help.convert(stop2.getBreite());
            double long1 = help.convert(stop1.getLaenge());
            double long2 = help.convert(stop2.getLaenge());
            var hav = new Haversine(lat1, long1, lat2, long2);
            Map<String,Object> mapout = help.returnMap(hav, stop1, stop2);          
            return mapout;
            }

        catch(Exception e){
            var error = new StopNotFound("No Stop found for "+keyname+" "+ DS1+" or "+ DS2);
            throw error;
        }
    }

    

    
     
         
    
}
