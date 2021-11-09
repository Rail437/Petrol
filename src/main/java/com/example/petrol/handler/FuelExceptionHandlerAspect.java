package com.example.petrol.handler;

import com.example.petrol.exception.FuelException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Aspect
@Component
public class FuelExceptionHandlerAspect {

    @Pointcut("@annotation(com.example.petrol.handler.FuelExceptionHandler)")
    public void handlerAnnotation(){}

    @Around("handlerAnnotation()")
    public String afterEx(ProceedingJoinPoint pjp){
        String result;
        try {
            result = (String) pjp.proceed();
        }catch (FuelException e){
            return "errorPage";
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "errorPage";
        }
        return result;
    }
}
