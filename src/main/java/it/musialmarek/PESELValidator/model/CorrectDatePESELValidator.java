package it.musialmarek.PESELValidator.model;

import it.musialmarek.PESELValidator.CorrectDatePESEL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CorrectDatePESELValidator implements ConstraintValidator<CorrectDatePESEL, String> {
    @Override
    public void initialize(CorrectDatePESEL constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        int month = Integer.parseInt(value.substring(2, 4));
        int day = Integer.parseInt(value.substring(4, 6));
        return month != 0 && day != 0;
    }
}
