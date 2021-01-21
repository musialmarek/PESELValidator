package it.musialmarek.PESELValidator.model;

import it.musialmarek.PESELValidator.CorrectDatePESEL;

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
        int month = Integer.parseInt(value.substring(2, 4));
        int day = Integer.parseInt(value.substring(4, 6));
        int year=0;
        if(month<=12){
            year = Integer.parseInt(value.substring(0,2))+1900;

        }else if(month<=32){
            year = Integer.parseInt(value.substring(0,2))+2000;
            month = month-20;
        }else if(month<=52){
            year = Integer.parseInt(value.substring(0,2))+2100;
            month = month-40;
        }else if(month<=72){
            year = Integer.parseInt(value.substring(0,2))+2200;
            month = month-60;
        }else if(month<=92){
            year = Integer.parseInt(value.substring(0,2))+1800;
            month = month-80;
        }
        try {
            LocalDate date = LocalDate.of(year,month,day);
        } catch (DateTimeException e) {
            e.printStackTrace();
            return false;
        }
        return month != 0 && day != 0;
    }
}
