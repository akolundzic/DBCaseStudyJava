package com.vanessaapi.api.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import  org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import  java.lang.Override;

@ControllerAdvice
public class ApiExceptionHandlers extends ResponseEntityExceptionHandler{
  
    @ExceptionHandler(value ={StopNotFound.class})
    // @ResponseStatus(value= HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleApiRequestException(StopNotFound e, WebRequest request, ServletWebRequest servlet ) {

        LocalDateTime timestamp = LocalDateTime.now();
        String message = e.getMessage();
        // String path =((ServletWebRequest)request).getRequest().getRequestURI().toString();
        String path = servlet.getRequest().getRequestURL().toString();
        int status = HttpStatus.NOT_FOUND.value();
        String error = "No data was found for this request path";
        ApiError apiError = new ApiError(message,status,error,path,timestamp);
       
        return new ResponseEntity<Object>(apiError,HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        LocalDateTime timestamp = LocalDateTime.now();
        String message = ex.getMessage();
        // String path =((ServletWebRequest)request).getRequest().getRequestURI().toString();
        String path = ex.getRequestURL();
        int statuserror = HttpStatus.NOT_FOUND.value();
        String error = "No data was found for this request path";
        ApiError apiError = new ApiError(message,statuserror,error,path,timestamp);

        return new ResponseEntity<Object>(apiError,HttpStatus.NOT_FOUND);
    }
    
}
