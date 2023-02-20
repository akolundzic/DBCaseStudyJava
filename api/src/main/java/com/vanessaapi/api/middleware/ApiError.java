package com.vanessaapi.api.middleware;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ApiError extends RuntimeException {
    
    private String detail="No Endpoint route found";
    private String type="Error";
    private String title="Invalid Request";

    public ApiError( String message, String detail, String type, String title) {

        super(message);
        this.detail = detail;
        this.type = type;
        this.title = title;
    }
    //Default constructor
    public ApiError(String message) {
        super(message);
    }
}
