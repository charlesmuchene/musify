package dev.cstv.musify.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("@annotation(dev.cstv.musify.aop.Log)")
    public void Logging() {
    }

    @Before("Logging()")
    public void Log(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        Annotation annotation = method.getAnnotation(Log.class);

       // String message = ((Log) annotation).message();

        //System.out.println(message + " at " + joinPoint.getSignature());

    }
}
