package services;

import models.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/j2ee";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";
    private static void CheckDrive(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassCastException exception){
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public List<UserModel> GetAllUser(){
        String query = "select * from person";
        List<UserModel> userModelList = new ArrayList<>();
        try{
            CheckDrive();
            Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                UserModel userModel = new UserModel(
                        resultSet.getString("UserID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Email"),
                        resultSet.getString("Phone"),
                        resultSet.getString("UserAccount"),
                        resultSet.getDate("DayOfBirth").toLocalDate(),
                        resultSet.getString("Gender"),
                        resultSet.getString("Address"),
                        resultSet.getString("Images")
                );
                userModelList.add(userModel);
                System.out.println("UserId: " + resultSet.getString("UserID"));
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return userModelList;
    }
    public UserModel FetchUserModel(String UserID){
        String query = String.format("select  * from person where UserID = %s ",UserID);
        UserModel userResult = new UserModel(null, null, null, null, null,
                null, null, null, null, null);
        try{
            CheckDrive();
            Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            UserModel userModel = new UserModel(
                    resultSet.getString("UserID"),
                    resultSet.getString("FirstName"),
                    resultSet.getString("LastName"),
                    resultSet.getString("Email"),
                    resultSet.getString("Phone"),
                    resultSet.getString("UserAccount"),
                    resultSet.getDate("DayOfBirth").toLocalDate(),
                    resultSet.getString("Gender"),
                    resultSet.getString("Address"),
                    resultSet.getString("Images")
            );
            System.out.println("UserId: " + resultSet.getString("UserID"));
            userResult = userModel;
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return userResult;
    }
    public boolean CheckUser(String UserID){
        String query = String.format("select  * from person where UserID = %s ",UserID);
        try{
            CheckDrive();
            Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet != null){
                return true;
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return false;
    }
}
