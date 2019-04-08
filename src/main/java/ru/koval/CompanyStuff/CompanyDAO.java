package ru.koval.CompanyStuff;

import ru.koval.UsersStuff.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCTraining", "root", "0000");
    }

    public void addToTable(Company company) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users.CompanyTable(name, type) value(?,?) ")){
            preparedStatement.setString(1,company.getCompanyName());
            preparedStatement.setString(2,company.getType());

            preparedStatement.execute();
        }
    }

    public Company getFromTable(String name) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name,type from users.CompanyTable where name = ?")){
            preparedStatement.setString(1,name);


            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            return new Company(rs.getString("name"),rs.getString("type"));
        }
    }

    public List<Company> getAllFromTable() throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name,type from users.CompanyTable")){


            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Company> out = new ArrayList<>();
            while(rs.next()){
                out.add(new Company(rs.getString("name"),rs.getString("type")));
            }

            return out;
        }
    }
}
