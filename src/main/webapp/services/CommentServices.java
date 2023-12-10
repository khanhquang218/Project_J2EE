package services;

import models.CommentModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentServices {
    private static final Configura configura = new Configura();
    //Tạo Comment
    public boolean CreateComment(CommentModel newComment) {
        PostServices postServices = new PostServices();
        var ResultOfCheckPostID = postServices.CheckPostIsExists(newComment.PostID);
        if (ResultOfCheckPostID) {
            String query = "INSERT INTO comments (CommentID, Content, UserID, ParentID, PostID, CreateDate)" +
                    " VALUES (?,?,?,?,?,?)";
            try {
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setInt(1, newComment.CommentID);
                preparedStatement.setString(2, newComment.Content);
                preparedStatement.setString(3, newComment.UserID);
                preparedStatement.setInt(3, newComment.ParentID);
                preparedStatement.setInt(4,newComment.PostID);
                preparedStatement.setDate(5, Date.valueOf(newComment.CreateDate));
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }
    // Lấy toàn bộ comment trong Post
    public List<CommentModel> GetAllComments(){
        List<CommentModel> commentModelList = new ArrayList<>();
        String query = "select * from comments";
        try {
            Configura.CheckDrive();
            Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                CommentModel comment = new CommentModel(
                        resultSet.getInt("CommentID"),
                        resultSet.getString("Content"),
                        resultSet.getInt("UserID"),
                        resultSet.getInt("ParentID"),
                        resultSet.getInt("PostID"),
                        resultSet.getDate("CreateDate").toLocalDate()
                );
                System.out.println("CommentID: " + resultSet.getInt("CommentID"));
                commentModelList.add(comment);
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return commentModelList;
    }

}
