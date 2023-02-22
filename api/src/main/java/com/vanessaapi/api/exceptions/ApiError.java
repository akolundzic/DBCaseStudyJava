package com.vanessaapi.api.exceptions;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiError {

    private String message;
    // private HttpStatus status;
    int status;
    private String error; //what kind of error internal for example
    private String path;
    private LocalDateTime timestamp;
    
}
