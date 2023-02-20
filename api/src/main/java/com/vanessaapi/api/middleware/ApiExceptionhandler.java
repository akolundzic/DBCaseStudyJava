package com.vanessaapi.api.middleware;

// import com.vanessaapi.api.middleware.ApiError;
import java.net.URI;
import java.net.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;

@EnableWebMvc
@ControllerAdvice
public class ApiExceptionhandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiError.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetail handleStopNotFound(ApiError ex, WebRequest req) {

        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        pd.setType(URI.create(ex.getType()));
        pd.setTitle(ex.getTitle());
        pd.setDetail(ex.getDetail());
        return pd;
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleInternal(Exception ex, HttpServletRequest request, HttpServletResponse response) {
                
         return new ResponseEntity<Object>(new ApiError(ex.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
