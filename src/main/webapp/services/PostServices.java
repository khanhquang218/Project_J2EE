package services;

import models.PostModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * kiểm tra drive hoạt động hay không
 * trả về toàn bài post có trong database
 * trả về toàn bộ bài post của một người dùng bất kì bằng UserID
 * trả về toàn bộ bài post của người dùng bằng UserName
 * tìm kiếm bài post dựa vào postID
 * kiểm tra bài post đã tồn tại hay chưa
 * tạo 1 bài post mới
 * xóa bài post cũ
 * chỉnh sửa bài post cũ
 */
public class PostServices {
    private static final Configura configura = new Configura();
    private static final UserServices userService = new UserServices();
    //lấy toàn bộ bài post hiện có trong database
    public List<PostModel> GetAllPosts(){
        List<PostModel> postModelList = new ArrayList<>();
        String query = "select * from post ";
        try{
            Configura.CheckDrive();
            Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                PostModel post = new PostModel(
                        resultSet.getInt("PostID"),
                        resultSet.getString("UserID"),
                        resultSet.getString("Image"),
                        resultSet.getString("Content"),
                        resultSet.getDate("DatePost").toLocalDate(),
                        resultSet.getDate("Modifed").toLocalDate(),
                        resultSet.getDate("LastModifedTime").toLocalDate()
                );

                System.out.println("PostID: " + resultSet.getString("PostID"));
                postModelList.add(post);
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return postModelList;
    }
    //trả về toàn bộ bài post của một người dùng bất kì bằng UserID
    public List<PostModel> GetPostOfUserID(String UserID){
        String query = String.format("select  * from post where UserID = %d ",UserID);
        List<PostModel> postModelList = new ArrayList<>();
        var ResultOfCheckUser = userService.CheckUserIsExists(UserID);
        if(ResultOfCheckUser == true){
            try{
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    PostModel post = new PostModel(
                            resultSet.getInt("PostID"),
                            resultSet.getString("UserID"),
                            resultSet.getString("Image"),
                            resultSet.getString("Content"),
                            resultSet.getDate("DatePost").toLocalDate(),
                            resultSet.getDate("Modifed").toLocalDate(),
                            resultSet.getDate("LastModifedTime").toLocalDate()
                    );
                    System.out.println("PostID: " + resultSet.getString("PostID"));
                    System.out.println("UserID: " + resultSet.getString("UserID"));
                    postModelList.add(post);
                }
            }
            catch (SQLException exception){
                exception.printStackTrace();
            }
        }
        return postModelList; //dữ liệu chỉ mới chọn lọc và đưa về thành 1 dạng danh sách.
    }
    //tìm kiếm post theo UserName
    public List<PostModel> GetPostsByUserName(String UserAccount){
        List<PostModel> postModelList = new ArrayList<>();
        var resultOfCheck = userService.CheckUserNameExists(UserAccount);
        if(resultOfCheck){
            var userModelList = userService.FetchUserModelByUserName(UserAccount);
            try {
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL,configura.JDBC_USER, configura.JDBC_PASSWORD);
                for (var element : userModelList) {
                    String query = String.format("select * from post where UserId = %s", element.UserID);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        PostModel post = new PostModel(
                                resultSet.getInt("PostID"),
                                resultSet.getString("UserID"),
                                resultSet.getString("Image"),
                                resultSet.getString("Content"),
                                resultSet.getDate("DatePost").toLocalDate(),
                                resultSet.getDate("Modifed").toLocalDate(),
                                resultSet.getDate("LastModifedTime").toLocalDate()
                        );
                        postModelList.add(post);
                    }
                }
            }
            catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
            return postModelList;
        }
        return null;
    }


    //kiểm tra bài post đã tồn tại hay chưa
    public boolean CheckPostIsExists(int PostID) {
        String query = String.format("select  * from post where PostID = '%d' ", PostID);
        try{
            Configura.CheckDrive();
            Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet != null) {
                return true;
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return false;
    }
    // tạo mới một bài post
    public boolean CreateNewPost(PostModel newPost){
        String query = "INSERT INTO post(PostID, UserID, Image, Content, DatePost, Modifed, LastModifedTime) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            Configura.CheckDrive();
            Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,newPost.PostID);
            preparedStatement.setString(2, newPost.UserID);
            preparedStatement.setString(3, newPost.Image);
            preparedStatement.setString(4, newPost.Content);
            preparedStatement.setString(5, String.valueOf(newPost.DatePost));
            preparedStatement.setString(6, String.valueOf(newPost.Modifed));
            preparedStatement.setString(7, String.valueOf(newPost.LastModifedTime));
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception){
            exception.printStackTrace();
            return false;
        }
        return true ;
    }
    //xóa một bài post cũ

    public boolean DeletePostModel(int PostID) {
        String query = String.format("DELETE FROM post WHERE PostID = '%d'", PostID);
        var resultOfCheck = CheckPostIsExists(PostID);
        if (resultOfCheck) {
            try {
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            return false;
        }
        return false;
    }

    //cập nhật một bài post sẵn có
    //cập nhật nội dung, hình ảnh, và thời gian truy cập lần cuối

    public boolean EditPostModel(int PostID, String newContent, String newImages, LocalDate newLastModifedTime) {
        String query = "UPDATE post SET Image = ?, Content = ?, LastModifedTime = ? WHERE PostID = ?";
        var ResultOfCheck = CheckPostIsExists(PostID);
        if (ResultOfCheck) {
            try {
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, newImages);
                preparedStatement.setString(2, newContent);
                preparedStatement.setDate(3, Date.valueOf(newLastModifedTime)); // Chuyển LocalDate thành java.sql.Date
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