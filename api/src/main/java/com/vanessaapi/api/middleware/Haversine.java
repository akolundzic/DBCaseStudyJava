package com.vanessaapi.api.middleware;
import java.lang.Math;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Haversine {

    final static double earthRadius = (6356.752+6378.137)/2.0;
    private double lat1;
    private double long1;
    private double lat2;
    private double long2;

    public long getDistance() { 
       
        double deltaLat = Math.toRadians(lat2 - lat1);
        double deltaLong = Math.toRadians(long2 - long1);
        double Lat1 = Math.toRadians(lat1);
        double Lat2 = Math.toRadians(lat2);

        double content = Math.pow(Math.sin(deltaLat/2.0),2)+
                         Math.cos(Lat1)*Math.cos(Lat2)*Math.pow(Math.sin(deltaLong/2.0),2);

        long distance =Math.round(2.0*earthRadius*Math.asin(Math.sqrt(content)));
        
        return distance; 
    }

}
