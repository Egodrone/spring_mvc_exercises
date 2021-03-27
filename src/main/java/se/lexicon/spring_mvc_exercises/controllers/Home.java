package se.lexicon.spring_mvc_exercises.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Controller
public class Home {
    private List<String> emailList;
    //create variable or list for the normal
    //create same for hypothermia


    @PostConstruct
    public void init() {
        if (emailList == null) {
            emailList = new ArrayList<>();
        }
    }


    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /*
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }*/


    @PostMapping(path = "/contact")
    public String email(@RequestParam String email) {
        System.out.println(email);
        emailList.add(email);
        System.out.println(emailList.size());
        return "redirect:/contact/";
    }


    @GetMapping("/about")
    public String about() {
        return "about";
    }


    @GetMapping("/contact")
    public String contactList(Model model) {
        String testName = "test";
        System.out.println("emailList = " + emailList);
        model.addAttribute("emailList", emailList);
        return "contact";
    }


    @GetMapping("/temp")
    public String temp() {
        return "temp";
    }


}
