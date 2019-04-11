package ru.koval.UsersStuff;

import java.sql.*;

public class UserDAO {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCTraining?verifyServerCertificate=false&useSSL=true", "root", "0000");
    }

    public void addToTable(User user) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users.UsersTable(login, password) value(?,?) ")){
            preparedStatement.setString(1,user.getLogin());
            preparedStatement.setString(2,user.getPassword());

            preparedStatement.execute();
        }
    }

    public User getFromTable(String login) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT login,password from users.UsersTable where login = ?")){
            preparedStatement.setString(1,login);


            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            return new User(rs.getString("login"),rs.getString("password"));
        }
    }
}
