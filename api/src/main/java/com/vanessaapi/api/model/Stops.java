package com.vanessaapi.api.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection =  "Bahnhoefe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stops {

    @Id
    private String _id;
    @Field("DS100")
    private String DS100;//is the primary Id for the endpoints, query
    private String EVA_NR;
    private String IFOPT;
    private String NAME;
    private String Verkehr;
    private String Laenge;
    private String Breite;
    private String Betreiber_Name;
    private String Status;
    
}
