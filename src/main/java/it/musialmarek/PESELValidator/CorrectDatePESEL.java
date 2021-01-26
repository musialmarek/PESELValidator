package it.musialmarek.PESELValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CorrectDatePESELValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CorrectDatePESEL {
    String message() default "{correctDatePESEL.error.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

