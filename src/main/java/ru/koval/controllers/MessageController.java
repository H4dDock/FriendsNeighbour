package ru.koval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.koval.domain.User;
import ru.koval.service.ChatMessageService;

import java.util.List;

@Controller
public class MessageController {
    @Autowired
    ChatMessageService chatMessageService;

    @GetMapping("/message")
    public String getMessages(Model model, @AuthenticationPrincipal User user){
        List<String> fromUser = chatMessageService.getAuthorsOfMessages(user);
        model.addAttribute("authors", fromUser);

        return "messages";
    }

    @PostMapping("/message")
    public String postMessage(Model model, @RequestParam String toUser,
                              @RequestParam String message, @AuthenticationPrincipal User user){
        chatMessageService.saveMessage(user,toUser,message);

        List<String> fromUser = chatMessageService.getAuthorsOfMessages(user);
        model.addAttribute("authors", fromUser);
        return "redirect:/message";
    }

    @GetMapping("/message/{author}")
    public String getConversation(@PathVariable("author") String author, @AuthenticationPrincipal User user, Model model){
        model.addAttribute("messages", chatMessageService.getConversation(user.getUsername(), author));
        model.addAttribute("user", user);
        model.addAttribute("toUser", author);

        return "conversation";
    }
}
