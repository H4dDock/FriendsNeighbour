package ru.koval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.koval.domain.User;
import ru.koval.UsersStuff.UsersRoles;
import ru.koval.repos.UserRepo;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;

@Controller
public class AuthoController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String newUser(User user, Map<String, Object> model) throws SQLException {
        User userDB = userRepo.findByUsername(user.getUsername());

        if(userDB != null){
            model.put("message","User exist");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(UsersRoles.User));
        userRepo.save(user);

        return "redirect:/login";
    }
}
