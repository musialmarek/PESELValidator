package it.musialmarek.PESELValidator.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PESEL {
    @NotBlank
    @Length(min = 11, message = "za krótki")
    @Size(max = 11, message = "za długi")
    @org.hibernate.validator.constraints.pl.PESEL
    private String number;
}
