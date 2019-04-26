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
import ru.koval.service.UserService;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @RequestMapping("/userList")
    public String userListPage(Model model){
        model.addAttribute("users",userService.getAllUsers());

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

        userService.saveChanges(user, newPass);

        return  "redirect:/user/profile";
    }

    @PostMapping("/viewProfile")
    public String viewUsersProfile(@RequestParam String username, Model model) {
        model.addAttribute("user", userService.findUserByUsername(username));

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

        model.addAttribute("user", userService.editUserByAdmin(username,form));
        model.addAttribute("roles", UsersRoles.values());

        return "editProfileByAdmin";
    }
}
