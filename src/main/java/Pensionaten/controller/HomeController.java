package Pensionaten.controller;

import Pensionaten.dto.BookingDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(org.springframework.ui.Model model) {
        model.addAttribute("booking", new BookingDTO());
        return "customers/home";
    }
}