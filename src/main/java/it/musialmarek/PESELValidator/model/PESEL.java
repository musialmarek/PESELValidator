package it.musialmarek.PESELValidator.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PESEL {
    @NotBlank
    @org.hibernate.validator.constraints.pl.PESEL
    private String number;
}
