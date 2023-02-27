package com.vanessaapi.api.middleware;
import java.util.LinkedHashMap;
import java.util.Map;
import com.vanessaapi.api.model.Stops;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HelperFunctions {

    public double convert( String input){ return Double.parseDouble(input.replace(",", "."));}

    public Map<String, Object> returnMap(Haversine hav, Stops stop1, Stops stop2){

        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("from :", stop1.getNAME());
        map.put("to :", stop2.getNAME());
        map.put("distance :", hav.getDistance());
        map.put("unit :", "km");

        return map;
    }
}
