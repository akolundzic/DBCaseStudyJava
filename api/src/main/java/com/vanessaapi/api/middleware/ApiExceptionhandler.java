package com.vanessaapi.api.middleware;
// import com.vanessaapi.api.middleware.ApiError;
import java.net.URI;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpStatus;


// import org.springframework.http.HttpHeaders;
// import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.http.ProblemDetail;

@ControllerAdvice
public class ApiExceptionhandler extends ResponseEntityExceptionHandler{


   
    @ExceptionHandler(ApiError.class)
    public ProblemDetail handleStopNotFound( ApiError ex, WebRequest req) {
        
    ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    pd.setType(URI.create(ex.getType()));
    pd.setTitle(ex.getTitle());
    pd.setDetail(ex.getDetail());
   

    
    return pd;
    }

}
