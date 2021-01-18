package it.musialmarek.PESELValidator;

import it.musialmarek.PESELValidator.model.PESEL;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class PESELController {
    @GetMapping("/")
    public String peselForm(Model model) {
        model.addAttribute("PESEL", new PESEL());
        return "pesel-form";
    }

    @PostMapping("/")
    public String peselValidation(@Valid PESEL PESEL, Errors errors) {
        if (errors.hasErrors()) {
            return "pesel-form";
        }
        log.error("PESEL CORRECT");
        return "redirect:/";
    }
}
