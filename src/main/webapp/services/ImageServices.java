package services;

import models.ImagesModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImageServices {
    private Configura configura = new Configura();

    public List<ImagesModel> GetAllImage() {
        String query = "select * from image";
        List<ImagesModel> imagesModelList = new ArrayList<>();
        try {
            Configura.CheckDrive();
            Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ImagesModel imagesModel = new ImagesModel(
                        resultSet.getString("ImageID"),
                        resultSet.getString("ImageName"),
                        resultSet.getString("ImageUrl"),
                        resultSet.getString("ParentID")
                );
                imagesModelList.add(imagesModel);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return imagesModelList;
    }

    public List<ImagesModel> GetAllImageOfUser(String userID) {
        String query = String.format("select * from image where ParentID = %s", userID);
        List<ImagesModel> imagesModelList = new ArrayList<>();
        UserServices userServices = new UserServices();
        var resultOfCheckUser = userServices.CheckUserIsExists(userID);
        if (resultOfCheckUser) {
            try {
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    ImagesModel imagesModel = new ImagesModel(
                            resultSet.getString("ImageID"),
                            resultSet.getString("ImageName"),
                            resultSet.getString("ImageUrl"),
                            resultSet.getString("ParentID")
                    );
                    imagesModelList.add(imagesModel);
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            return imagesModelList;
        }
        return null;
    }

    public boolean CreateImage (ImagesModel newImage){
        UserServices userServices = new UserServices();
        var resultOfCheckUser = userServices.CheckUserIsExists(newImage.ParentID);
        String query = "insert into image(ImageID, ImageName, ImageURL, ParentID) values (?,?,?,?)";
        if (resultOfCheckUser){
            try {
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,newImage.imageID);
                preparedStatement.setString(2,newImage.imageName);
                preparedStatement.setString(3,newImage.imageURL);
                preparedStatement.setString(4,newImage.ParentID);
                preparedStatement.executeUpdate();
                return  true;
            }
            catch (SQLException exception){
                exception.printStackTrace();
            }
            return  false;
        }
        return false;
    }
    public  boolean DeleteImage(String ImageID, String UserID)
    {
        String query = String.format("delete from  image where ImageID = '%s'",ImageID);
        var resultOfCheckImage = CheckImageIsExists(ImageID);
        UserServices userServices = new UserServices();
        var resultOfCheckUser = userServices.CheckUserIsExists(UserID);
        if (resultOfCheckImage && resultOfCheckUser){
            try {
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();
                return  true;
            }
            catch (SQLException exception){
                exception.printStackTrace();
            }
            return  false;
        }
        return false;
    }
    public  boolean CheckImageIsExists(String ImageID){
        String query = String.format("select * from image where ImageID = %s", ImageID);
        try{
            Configura.CheckDrive();
            Connection connection = DriverManager.getConnection(configura.JDBC_URL,configura.JDBC_USER, configura.JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                return  true;
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return false;
    }

}
