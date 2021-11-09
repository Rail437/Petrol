package com.example.petrol.service;

import com.example.petrol.Constants;
import com.example.petrol.exception.FuelException;
import com.example.petrol.handler.FuelExceptionHandler;
import org.springframework.stereotype.Service;

@FuelExceptionHandler
@Service
public class EngineService {

    public String powerUp(String type) {
        if(Constants.DIESEL.equalsIgnoreCase(type)){
            //some logic
            return "I work on diesel.";
        }
        if(Constants.PETROL.equalsIgnoreCase(type)){
            //some logic
            return "I work on petrol.";
        } else {
            throw new FuelException("Bad type.");
        }
    }
}
