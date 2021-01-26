package it.musialmarek.PESELValidator;

import it.musialmarek.PESELValidator.model.PESEL;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PESELService {

    public static LocalDate getDateByPESEL(PESEL pesel) {
        String value = pesel.getNumber();
        int month = Integer.parseInt(value.substring(2, 4));
        int day = Integer.parseInt(value.substring(4, 6));
        int year = 0;
        if (month <= 12) {
            year = Integer.parseInt(value.substring(0, 2)) + 1900;

        } else if (month <= 32) {
            year = Integer.parseInt(value.substring(0, 2)) + 2000;
            month = month - 20;
        } else if (month <= 52) {
            year = Integer.parseInt(value.substring(0, 2)) + 2100;
            month = month - 40;
        } else if (month <= 72) {
            year = Integer.parseInt(value.substring(0, 2)) + 2200;
            month = month - 60;
        } else if (month <= 92) {
            year = Integer.parseInt(value.substring(0, 2)) + 1800;
            month = month - 80;
        }
        return LocalDate.of(year, month, day);
    }

    public static boolean isMale(PESEL pesel) {
        int sex = Integer.parseInt(pesel.getNumber().substring(9, 10));
        return sex % 2 != 0;
    }
}
