package dev.cstv.musify.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("@annotation(log)")
    public void Logging(Log log) {
    }

    @AfterReturning("Logging(log)")
    public void Log(JoinPoint joinPoint, Log log) {
        System.out.println(log.message() + " at " + joinPoint.getSignature());
    }
}
