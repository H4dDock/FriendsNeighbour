package ru.koval.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.koval.CompanyStuff.Company;
import ru.koval.CompanyStuff.CompanyDAO;
import ru.koval.UsersStuff.User;
import ru.koval.UsersStuff.UserDAO;

import java.sql.SQLException;
import java.util.List;

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

    @RequestMapping("/registration")
    public String registrationPage(Model model){
        return "registration";
    }

    @RequestMapping("/hello")
    public String helloPage(Model model){
        return "hello";
    }

    @RequestMapping(value = "/newUser", method= RequestMethod.POST)
    public String newUser(@RequestParam("username") String name, @RequestParam("password") String password, Model model) throws SQLException {
        UserDAO userDAO = new UserDAO();
        userDAO.addToTable(new User(name, password));

        return "redirect:/login";
    }

    @RequestMapping("/mainPage")
    public String mainPage(Model model) throws SQLException {
        CompanyDAO companyDAO = new CompanyDAO();
        List<Company> companies = companyDAO.getAllFromTable();
        model.addAttribute("companies", companies);
        return "mainPage";
    }
}
