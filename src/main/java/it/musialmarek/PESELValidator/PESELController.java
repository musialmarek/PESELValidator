package it.musialmarek.PESELValidator;

import it.musialmarek.PESELValidator.model.PESEL;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@Slf4j
public class PESELController {
    @GetMapping("/")
    public String peselForm(Model model) {
        model.addAttribute("PESEL", new PESEL());
        return "pesel-form";
    }

    @PostMapping("/")
    public String peselValidation(Model model, @Valid PESEL PESEL, Errors errors) {
        if (errors.hasErrors()) {
            return "pesel-form";
        }
        model.addAttribute("PESEL", PESEL);
        LocalDate dateOfBurn = PESELService.getDateByPESEL(PESEL);
        model.addAttribute("date", dateOfBurn);
        log.debug("date: {}", dateOfBurn);
        boolean male = PESELService.isMale(PESEL);
        model.addAttribute("male", male);
        log.debug("male: {}", male);
        log.debug("PESEL CORRECT");
        return "pesel-form";
    }
}
