package com.example.petrol.service;

import com.example.petrol.Constants;
import com.example.petrol.exception.FuelException;
import com.example.petrol.handler.FuelExceptionHandler;
import org.springframework.stereotype.Service;

@Service
public class PetrolService implements EngineService{

    @FuelExceptionHandler
    @Override
    public String powerUp(String type) throws FuelException {
        if(Constants.PETROL.equalsIgnoreCase(type)){
            //some logic
            return "I work on petrol.";
        } else {
            throw new FuelException("Bad type.");
        }
    }
}
