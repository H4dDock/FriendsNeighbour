package ru.koval.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.koval.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
