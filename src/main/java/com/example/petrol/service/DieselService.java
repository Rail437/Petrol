package com.example.petrol.service;

import com.example.petrol.Constants;
import com.example.petrol.exception.FuelException;
import com.example.petrol.handler.FuelExceptionHandler;
import org.springframework.stereotype.Service;

@Service
public class DieselService implements EngineService {

    @FuelExceptionHandler
    @Override
    public String powerUp(String type) throws FuelException {
        if(Constants.DIESEL.equalsIgnoreCase(type)){
            //some logic
            return "I work on diesel.";
        } else {
            throw new FuelException("Bad type.");
        }
    }
}
