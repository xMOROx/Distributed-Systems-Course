package pl.edu.agh.restapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.agh.restapi.DAO.RequestDao;

@Controller
@RequestMapping("/api/v1/")
public class RequestController {

    @GetMapping
    public String request(Model model) {
        model.addAttribute("RequestDao", new RequestDao());
        return "index";
    }

    @PostMapping
    public String greetingSubmit(@ModelAttribute RequestDao request, Model model) {
        model.addAttribute("request", request);
        return "result";
    }
}
