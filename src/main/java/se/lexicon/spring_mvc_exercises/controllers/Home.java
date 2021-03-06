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
    private List<String> tempList;
    private String tempStatus = "";


    @PostConstruct
    public void init() {
        if (emailList == null) {
            emailList = new ArrayList<>();
            tempList = new ArrayList<>();
        }
    }


    @GetMapping("/index")
    public String index() {
        return "index";
    }


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
        System.out.println("emailList = " + emailList);
        model.addAttribute("emailList", emailList);
        return "contact";
    }


    @GetMapping("/temp")
    public String temp(Model model) {
        model.addAttribute("tempList", tempList);
        System.out.println("tempList = " + tempList);
        return "temp";
    }


    @PostMapping(path = "/temp")
    public String tempStatus(@RequestParam int temp) {
        System.out.println(temp);

        if (temp < 36) {
            System.out.println(" Hypothermia ");
            tempStatus = " Hypothermia ";
            tempList.add("Hypothermia");
        } else if (temp > 35 && temp < 38) {
            System.out.println(" Normal temperature ");
            tempStatus = " Normal ";
            tempList.add("Normal");
        } else {
            System.out.println(" Fever ");
            tempStatus = " Fever ";
            tempList.add("Fever");
        }

        return "redirect:/temp/";
    }

}
