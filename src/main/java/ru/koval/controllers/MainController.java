package ru.koval.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.koval.CompanyStuff.Company;
import ru.koval.CompanyStuff.CompanyDAO;
import ru.koval.UsersStuff.User;
import ru.koval.UsersStuff.UserDAO;

import java.sql.SQLException;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/mainPage")
    public String mainPage(Model model) throws SQLException {
        CompanyDAO companyDAO = new CompanyDAO();
        List<Company> companies = companyDAO.getAllFromTable();
        model.addAttribute("companies", companies);
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

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String newUser(@RequestParam(name = "username") String name, @RequestParam(name = "password") String pass) throws SQLException {
        UserDAO userDAO = new UserDAO();

        userDAO.addToTable(new User(name, pass));

        return "redirect:/login";
    }
}

/*
@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(){
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
*/
