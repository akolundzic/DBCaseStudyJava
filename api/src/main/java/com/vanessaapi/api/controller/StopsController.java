package com.vanessaapi.api.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StopsController {

    @GetMapping("/{DS100}")
    @ResponseBody
    public String testEndpoint(@PathVariable String DS100){
        
        return "DS100: "+DS100;
    }


    
}
