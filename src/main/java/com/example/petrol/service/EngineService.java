package com.example.petrol.service;

import com.example.petrol.exception.FuelException;
import com.example.petrol.handler.FuelExceptionHandler;
import org.springframework.stereotype.Service;

@Service
public interface EngineService {
    @FuelExceptionHandler
    String powerUp(String type) throws FuelException;
}
