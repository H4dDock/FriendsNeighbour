package ru.koval.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.koval.domain.ChatMessage;
import ru.koval.domain.User;
import ru.koval.repos.ChatMessageRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatMessageService {
    @Autowired
    ChatMessageRepo chatMessageRepo;

    public List<String> getAuthorsOfMessages(User user){
        List<ChatMessage> messages = chatMessageRepo.findByToUser(user.getUsername());
        List<String> fromUser = messages.stream().map(ChatMessage::getFromUser).distinct().collect(Collectors.toList());

        return fromUser;
    }

    public void saveMessage(User user, String toUser, String message){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setFromUser(user.getUsername());
        chatMessage.setToUser(toUser);
        chatMessage.setMessage(message);

        chatMessageRepo.save(chatMessage);
    }

    public List<ChatMessage> getConversation(String toUser, String fromUser){
        List<ChatMessage> out = chatMessageRepo.findByToUserAndFromUser(toUser, fromUser);
        out.addAll(chatMessageRepo.findByToUserAndFromUser(fromUser,toUser));
        return out;
    }
}
