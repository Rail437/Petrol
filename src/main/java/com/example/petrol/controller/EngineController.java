package com.example.petrol.controller;

import com.example.petrol.Constants;
import com.example.petrol.exception.FuelException;
import com.example.petrol.handler.FuelExceptionHandler;
import com.example.petrol.service.DieselService;
import com.example.petrol.service.EngineService;
import com.example.petrol.service.PetrolService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class EngineController {
    private final DieselService dieselService;
    private final PetrolService petrolService;

    private Map<String, EngineService> servicesMap;

    @GetMapping()
    public String hello(Model model){
        return "hello";
    }

    @FuelExceptionHandler
    @GetMapping("/mvc/fuel/check/")
    public String checkEngine(Model model,@PathParam("type") String type) throws FuelException {
        if(!servicesMap.containsKey(type)){
            throw new FuelException("");
        }
        EngineService service = servicesMap.get(type);
        model.addAttribute("resp", service.powerUp(type));
        return "hello";
    }

    @Autowired
    private void init(){
        servicesMap = new HashMap<>();
        servicesMap.put(Constants.DIESEL,dieselService);
        servicesMap.put(Constants.PETROL,petrolService);
    }
}
