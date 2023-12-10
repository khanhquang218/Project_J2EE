package services;

import models.CommentModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommentServices {
    private static final Configura configura = new Configura();
    // Lấy toàn bộ comment
//    public List<CommentModel> GetAllComments(){
//        List<CommentModel> commentModelList = new ArrayList<>();
//        String query = "select * from comments";
//        try {
//            Configura.CheckDrive();
//            Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//            while (resultSet.next()){
//                CommentModel comment = new CommentModel(
//                        resultSet.getInt("CommentID"),
//                        resultSet.getString("Content"),
//                        resultSet.getString("UserID"),
//                        resultSet.getInt("ParentID"),
//                        resultSet.getInt("PostID"),
//                        resultSet.getDate("CreateDate").toLocalDate()
//                );
//                System.out.println("CommentID: " + resultSet.getInt("CommentID"));
//                commentModelList.add(comment);
//            }
//        }
//        catch (SQLException exception){
//            exception.printStackTrace();
//        }
//        return commentModelList;
//    }
    //Lấy tất cả comment của bài post
    public List<CommentModel> GetAllCommentOfPost(int PostID){
        PostServices postServices = new PostServices();
        var resultOfCheckPost = postServices.CheckPostIsExists(PostID);
        List<CommentModel> commentModelList = new ArrayList<>();
        String query = String.format("select * from comments where PostID = %d",PostID);
        if(resultOfCheckPost == true){
            try {
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    CommentModel commentModel = new CommentModel(
                            resultSet.getInt("CommentID"),
                            resultSet.getString("Content"),
                            resultSet.getString("UserID"),
                            resultSet.getInt("ParentID"),
                            resultSet.getInt("PostID"),
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
        return null;
    }
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
    //Delete Comment
    public boolean DeleteComment(int PostID, String UserID){
        UserServices userServices = new UserServices();
        PostServices postServices = new PostServices();
        var resultOfCheckUser = userServices.CheckUserIsExists(UserID);
        var resultOfCheckPost = postServices.CheckPostIsExists(PostID);
        String query = String.format("delete from comments where UserId = '%s' and PostID = %d ",UserID,PostID);
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
    //Chỉnh sửa comment của bài viết
    public boolean EditCommentModel(int PostID, String newContent, String newCreateDate) {
        String query = "UPDATE post SET Content = ?, CreateDate = ? WHERE PostID = ?";
        PostServices postServices = new PostServices();
        var ResultOfCheck = postServices.CheckPostIsExists(PostID);
        if (ResultOfCheck) {
            try {
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(2, newContent);
                preparedStatement.setDate(3, Date.valueOf(newCreateDate));
                preparedStatement.setInt(4, PostID);

                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            return false;
        }
        return false;
    }

}
