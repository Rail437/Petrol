package com.example.petrol.handler;

import com.example.petrol.exception.FuelException;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FuelExceptionHandlerAspect {

    @Pointcut("@annotation(com.example.petrol.handler.FuelExceptionHandler)")
    public void handlerAnnotation(){}

    @AfterThrowing(pointcut = "handlerAnnotation()")
    public String afterEx(){
        return "error";
    }
}
