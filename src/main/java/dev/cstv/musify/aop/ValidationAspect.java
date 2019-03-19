package dev.cstv.musify.aop;

import dev.cstv.musify.exception.ValidationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import java.util.List;

@Aspect
@Component
public class ValidationAspect {

    @Autowired
    MessageSourceAccessor messageAccessor;

    @Autowired
    private Validator validator;

    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;


    @Pointcut("@annotation(dev.cstv.musify.aop.ServiceValidation)")
    public void ServiceValidation() {
    }

    @Before("ServiceValidation() && args(object)")
    public void log(JoinPoint joinPoint, Object object) {

        //Bind Error to Bean
        Errors error = new BeanPropertyBindingResult(object, object.getClass().getName());

        validator.validate(object, error);

        if (error.hasErrors()) {

            List<FieldError> fieldErrors = error.getFieldErrors();

            fieldErrors.forEach(fieldError -> {

                throw new ValidationException(messageAccessor.getMessage(fieldError));
            });

        }

        System.out.println("logging: " + joinPoint.getSignature());

    }

}
