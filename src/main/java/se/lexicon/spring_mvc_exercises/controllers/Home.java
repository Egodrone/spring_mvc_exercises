package se.lexicon.spring_mvc_exercises.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Home {

    @GetMapping("/index")
    public String index() {
        return "index";
    }


}
