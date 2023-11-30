package services;

import models.CommentModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
* tạo ra từng mảng để chưa các comment
* lấy thông tin của các mảng comment hiện có (Mảng gốc đi liền với post)
* tạo comment
* tạo reply
* kèm điều hiện postlike tương ứng
*/
public class CommentService {
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
    public List<CommentModel> CreateSpaceCommentOfPost(String PostID){
        List<CommentModel> commentModelList = new ArrayList<>();
        String query = String.format("select * from comment where PostID = %s",PostID);
        try{
            CheckDrive();
            Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                CommentModel commentModel = new CommentModel(
                    resultSet.getString("CommentID"),
                    resultSet.getString("Content"),
                    resultSet.getString("PostID"),
                    resultSet.getString("ReplyTo"),
                    resultSet.getString("UserID"),
                    resultSet.getDate("CreateDate").toLocalDate()
                );
                commentModelList.add(commentModel);
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return commentModelList;
    }
    public boolean CreateComment(CommentModel newComment){
        String query = "INSERT INTO comment(CommentID, Content, PostID, ReplyID, UserID) " +
                "VALUES (?, ?, ?, ?, ?)";
        try{
            CheckDrive();
            Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,newComment.CommentID);
            preparedStatement.setString(2, newComment.Content);
            preparedStatement.setString(3, newComment.PostID);
            preparedStatement.setString(4, newComment.ReplyTo);
            preparedStatement.setString(5,String.valueOf(newComment.CreateDate));
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception){
            exception.printStackTrace();
            return false;
        }
        return true ;
    }

    public  boolean IsCheckCommentExist(String CommentID){
        String query = String.format("select * from comment where CommentID = %s",CommentID);
        try {
            CheckDrive();
            Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet != null )
                return true;
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return false;
    }
    public boolean DeleteComment(String CommentID){
        String query = String.format("delete * from post where PostID = %s",CommentID);
        try {
            CheckDrive();
            Connection connection  = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return true;
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return false;
    }
}
