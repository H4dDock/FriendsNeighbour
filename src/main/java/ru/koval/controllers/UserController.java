package ru.koval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.koval.repos.UserRepo;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/userList")
    public String userListPage(Model model){
        model.addAttribute("users",userRepo.findAll());

        return "userList";
    }
}
