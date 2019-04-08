package ru.koval.service;

import org.springframework.stereotype.Service;
import ru.koval.UsersStuff.User;
import ru.koval.UsersStuff.UserDAO;

import java.sql.SQLException;

@Service
public class UserServiceSQL implements UserService {
    @Override
    public User getUser(String login) throws SQLException {
        UserDAO userDAO = new UserDAO();

        User user = userDAO.getFromTable(login);
        return user;
    }
}
