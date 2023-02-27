package com.vanessaapi.api.exceptions;
// import org.springframework.http.HttpStatus;

// import lombok.AllArgsConstructor;
// import lombok.Data;

import java.time.LocalDateTime;
// import java.util.Set;

// @Data
// @AllArgsConstructor
public class ApiError {

    private String message;
    // private HttpStatus status;
    int status;
    private String error; //what kind of error internal for example
    private String path;
    private LocalDateTime timestamp;

    public ApiError(String message, int status, String error, String path, LocalDateTime timestamp) {

        this.message = message;
        this.status = status;
        this.error = error;
        this.path = path;
        this.timestamp = timestamp;
    }

    public ApiError(String message, String path, LocalDateTime timestamp){
        this.message = message;
        this.timestamp = timestamp;
        this.path = path;
    }
    public void setError(String error){ this.error = error;}
    public void setStatus(int status){ this.status = status;}
   
    public String getError(){ return this.error;}
    public int getStatus(){ return this.status;}
    public LocalDateTime getTimestamp(){ return this.timestamp;}
    public String getPath(){ return this.path;}
    public String getMessage(){ return this.message;}    
}
