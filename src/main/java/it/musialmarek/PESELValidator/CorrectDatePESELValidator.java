package it.musialmarek.PESELValidator;

import it.musialmarek.PESELValidator.model.PESEL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.DateTimeException;
import java.time.LocalDate;

public class CorrectDatePESELValidator implements ConstraintValidator<CorrectDatePESEL, String> {
    @Override
    public void initialize(CorrectDatePESEL constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        try {
            LocalDate date = PESELService.getDateByPESEL(new PESEL(value));
        } catch (DateTimeException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
