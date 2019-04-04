package ru.koval.UsersStuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    private Connection GetConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCTraining", "root", "0000");
    }

    public void AddToTable(User user) throws SQLException {
        try(Connection connection = GetConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO UsersTable(login, password) value(?,?) ")){
            preparedStatement.setString(1,user.getLogin());
            preparedStatement.setString(2,user.getPassword());

            preparedStatement.execute();
        }
    }
}
