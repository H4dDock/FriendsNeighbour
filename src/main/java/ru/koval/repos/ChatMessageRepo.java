package ru.koval.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.koval.domain.ChatMessage;

import java.util.List;

public interface ChatMessageRepo extends JpaRepository<ChatMessage,Long> {
    List<ChatMessage> findByToUser(String toUser);
    List<ChatMessage> findByToUserAndFromUser(String toUser, String fromUser);
}
