package se.lexicon.spring_mvc_exercises.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Home {

    @GetMapping("/index")
    public String index() {
        return "index";
    }


    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }


    @PostMapping(path = "/contact")
    public String email(@RequestParam String email) {
        System.out.println(email);
        return "contact";
    }


}
