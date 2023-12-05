package services;

import models.InteractModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*
* Check Drive
* CRUD Interact
*/
public class InteractServices {
    private static final Configura configura = new Configura();
    public List<InteractModel> GetAllInteracts(){
        List<InteractModel> interactModelList = new ArrayList<>();
        String query = "select * from interact";
        try {
            Configura.CheckDrive();
            Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                InteractModel interactModel = new InteractModel(
                        resultSet.getString("InteractID"),
                        resultSet.getInt("ParemtID"),
                        resultSet.getString("UserID")
                );
                interactModelList.add(interactModel);
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return interactModelList;
    }
    public List<InteractModel> GetAllInteractOfPost(int PostID){
        PostServices postServices = new PostServices();
        var resultOfCheckPost = postServices.CheckPostIsExists(PostID);
        List<InteractModel> interactModelList = new ArrayList<>();
        String query = String.format("select * from interact where PostID = %s",PostID);
        if(resultOfCheckPost == true){
            try {
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    InteractModel interactModel = new InteractModel(
                            resultSet.getString("InteractID"),
                            resultSet.getInt("ParemtID"),
                            resultSet.getString("UserID")
                    );
                    interactModelList.add(interactModel);
                }
            }
            catch (SQLException exception){
                exception.printStackTrace();
            }
            return interactModelList;
        }
        return null;
    }
    public boolean CreateAInteract(InteractModel newInteractModel){
        PostServices postServices = new PostServices();
        UserServices userServices = new UserServices();
        var resultOfCheckPost = postServices.CheckPostIsExists(newInteractModel.ParentID);
        var reusltOfCheckUser = userServices.CheckUserIsExists(newInteractModel.UserID);
        String query = "insert into interact(InteractID, ParentID, UserID, CountID)";
        if (resultOfCheckPost == true && reusltOfCheckUser == true ){
            try{
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL,configura.JDBC_USER, configura.JDBC_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query );
                preparedStatement.setString(1,newInteractModel.InteractID);
                preparedStatement.setString(2,String.valueOf(newInteractModel.ParentID));
                preparedStatement.setString(3, newInteractModel.UserID);
                preparedStatement.executeUpdate();
                return true;
            }
            catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
            return false;
        }
        return false;
    }
    public boolean DeleteAInteract(int PostID, String UserID){
        UserServices userServices = new UserServices();
        PostServices postServices = new PostServices();
        var resultOfCheckUser = userServices.CheckUserIsExists(UserID);
        var resultOfCheckPost = postServices.CheckPostIsExists(PostID);
        String query = String.format("delete * from interact where UserId = %s, PostID = %d ",UserID,PostID);
        if (resultOfCheckPost == true && resultOfCheckUser == true){
            try{
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL,configura.JDBC_USER,configura.JDBC_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();
                return true ;
            }
            catch (SQLException exception){
                exception.printStackTrace();
            }
            return false;
        }
        return false;
    }
}
