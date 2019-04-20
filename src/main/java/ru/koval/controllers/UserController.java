package ru.koval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.koval.UsersStaff.UsersRoles;
import ru.koval.domain.User;
import ru.koval.repos.UserRepo;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

    @GetMapping("/profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);

        return "profile";
    }

    @PostMapping("/profile")
    public String editProfile(Model model, @AuthenticationPrincipal User user, @RequestParam(name = "newPassword") String newPass) {
        model.addAttribute("user", user);

        boolean isEmailChanged= (newPass != null && !newPass.equals(user.getPassword())) ||
                (user.getPassword() != null && !user.getPassword().equals(newPass));

        if(isEmailChanged){
            user.setPassword(newPass);
            userRepo.save(user);
        }

        return  "redirect:/user/profile";
    }

    @PostMapping("/viewProfile")
    public String viewUsersProfile(@RequestParam String username, Model model) {
        model.addAttribute("user", userRepo.findByUsername(username));

        return "viewProfile";
    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", UsersRoles.values());

        return "editProfileByAdmin";
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public String userEditForm(@RequestParam String username, @RequestParam Map<String, String> form, Model model) {
        User user = userRepo.findByUsername(username);

        Set<String> roles = Arrays.stream(UsersRoles.values())
                .map(UsersRoles::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(UsersRoles.valueOf(key));
            }
        }

        userRepo.save(user);

        model.addAttribute("user", user);
        model.addAttribute("roles", UsersRoles.values());

        return "editProfileByAdmin";
    }
}
