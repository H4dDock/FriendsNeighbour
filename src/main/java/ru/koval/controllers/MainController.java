package ru.koval.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String start(Model model){
        return "index";
    }

    @RequestMapping("/login")
    public String loginPage(Model model){
        return "login";
    }

}
