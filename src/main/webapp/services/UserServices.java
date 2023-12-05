package services;

import models.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
* kiểm tra việc bổ sung drive
* lấy toàn bộ thông tin người dùng trong database
* tìm kiếm người dùng bằng UserID người dùng
* tìm kiếm người dùng bằng UserName của người dùng
* kiểm tra mã số người dùng đó có tồn tại hay chưa thông quá userID
* kiểm tra tên người dùng có tồn tại hay không thông qua UserName
*/
public class UserServices {
    private static final Configura configura = new Configura();
    //lấy toàn bộ thông tin người dùng có trong database
    public List<UserModel> GetAllUsers() {
        String query = "select * from person";
        List<UserModel> userModelList = new ArrayList<>();
        try {
            Configura.CheckDrive();
            Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                UserModel userModel = new UserModel(
                        resultSet.getString("UserID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Email"),
                        resultSet.getString("Phone"),
                        resultSet.getString("UserAccount"),
                        resultSet.getDate("DayOfBirth").toLocalDate(),
                        resultSet.getString("Gender"),
                        resultSet.getString("Address")
                );
                userModelList.add(userModel);
                System.out.println("UserId: " + resultSet.getString("UserID"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return userModelList;
    }
    //tìm kiếm user bằng UserID
    public UserModel FetchUserModelByUserID(String UserID){
        String query = String.format("select  * from person where UserID = %s ",UserID);
        UserModel userResult = new UserModel(null, null, null, null, null,
                null, null, null, null);
        var resultOfCheckUserIsExists = CheckUserIsExists(UserID);
        if (resultOfCheckUserIsExists){
            try{
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL,configura.JDBC_USER,configura.JDBC_PASSWORD);
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
                        resultSet.getString("Address")
                );
                System.out.println("UserId: " + resultSet.getString("UserID"));
                userResult = userModel;
            }
            catch (SQLException exception){
                exception.printStackTrace();
            }
            return userResult;
        }
        return  null;
    }

    //tìm kiếm user bằng UserName
    public  List<UserModel> FetchUserModelByUserName(String UserName){
        List<UserModel> userModelList = new ArrayList<>();
        String query = String.format("select * from person where UserName = %s", UserName);
        var resultOfCheckUserNameExists = CheckUserNameExists(UserName);
        try {
            Configura.CheckDrive();
            Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
            Statement statement =connection.createStatement();
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
                        resultSet.getString("Address")
                );
                userModelList.add(userModel);
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return  userModelList;
    }
    //Kiểm tra tên người dùng có tồn tại hay không thông UserName
    public boolean CheckUserNameExists(String UserName){
        String query = String.format("select  * from person where UserName = %s ",UserName);
        try{
            Configura.CheckDrive();
            Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
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
    //kiểm tra mã số người dùng có tồn tại hay không bằng UserUD
    public boolean CheckUserIsExists(String UserID){
        String query = String.format("select  * from person where UserID = %s ",UserID);
        try{
            Configura.CheckDrive();
            Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
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
    //
}
