package it.musialmarek.PESELValidator.model;

import it.musialmarek.PESELValidator.CorrectDatePESEL;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PESEL {
    @NotBlank
    @Length(min = 11, message = "za krótki")
    @Size(max = 11, message = "za długi")
    @org.hibernate.validator.constraints.pl.PESEL
    @CorrectDatePESEL(message = "zła data")
    private String number;
}
