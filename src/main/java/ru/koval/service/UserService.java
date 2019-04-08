package ru.koval.service;

import ru.koval.UsersStuff.User;

import java.sql.SQLException;

public interface UserService {

    User getUser(String login) throws SQLException;

}
