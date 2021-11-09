package com.example.petrol.controller;

import com.example.petrol.exception.FuelException;
import com.example.petrol.handler.FuelExceptionHandler;
import com.example.petrol.service.EngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.server.PathParam;

@Controller
@RequiredArgsConstructor
public class EngineController {

    private final EngineService engineService;


    @GetMapping()
    public String hello(Model model){
        return "hello";
    }

    @GetMapping("/mvc/fuel/check/")
    public String checkEngine(Model model,@PathParam("type") String type){
        model.addAttribute("resp", engineService.powerUp(type));
        return "hello";
    }
}
