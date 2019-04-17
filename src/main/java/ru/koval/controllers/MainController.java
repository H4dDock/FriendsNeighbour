package ru.koval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.koval.repos.CompanyRepo;

import java.sql.SQLException;

@Controller
public class MainController {
    @Autowired
    private CompanyRepo companyRepo;

    @GetMapping("/mainPage")
    public String mainPage(Model model) throws SQLException {
        model.addAttribute("companies", companyRepo.findAll());
        return "mainPage1";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String start(Model model) {
        return "index";
    }
}
