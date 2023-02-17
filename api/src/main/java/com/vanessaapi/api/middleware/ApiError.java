package com.vanessaapi.api.middleware;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError extends RuntimeException {
    
    private String detail;
    private String type;
    private String title;

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
