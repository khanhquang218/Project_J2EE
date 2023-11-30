package services;

import models.PostModel;
import models.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
* lấy toàn bộ bài viết
* lấy bài viết theo id người dùng cung cấp
* lấy bài viết theo tên người dùng cung cấp (user name có thể sẽ trùng hoặc không nên sẽ giải quyết ở định dạng danh sách)
* tìm kiếm tạo bài viết
* xóa bài viết
* chỉnh sửa bài viết cập nhật tại thời gian chỉnh sửa lần cuối
* kiểm tra id bài viết đã từng tồn tại hay chưa
* kiểm tra drive
* */
public class PostServices  {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/j2ee";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";
    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;
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
    public List<PostModel> GetAllPosts(){
        String query = "select * from post";
        List<PostModel> postModelList = new ArrayList<>();
        try{
            CheckDrive();
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                PostModel post = new PostModel(
                        resultSet.getString("PostID"),
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
    //lấy id người dùng khác trong danh sách bạn bè và xác thực có tồn tại hay không
    //truy cập lấy thông tim toàn bộ bài post hiển thị
    //đưa về 1 danh sách
    //trộn hoặc sắp xếp theo nhu cầu
    public List<PostModel> GetPostOfFriendByUserID(String UserID){
        String query = String.format("select  * from post where UserID = %s ",UserID);
        List<PostModel> postModelList = new ArrayList<>();
        UserService userService = new UserService();
        var ResultOfCheckUser = userService.CheckUser(UserID);
        if(ResultOfCheckUser == true){
            try{
                CheckDrive();
                connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    PostModel post = new PostModel(
                            resultSet.getString("PostID"),
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
    public  List<PostModel> GetListPostByUserNameOfUser(String UserName){
        UserService userService = new UserService();
        List<UserModel> userModelList = userService.FetchUserModelByUserName(UserName);
        List<PostModel> postModelList = new ArrayList<>();

        try{
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            for (var element : userModelList){
                String query = String.format("select * from post where UserId = %s",element.UserID);
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    PostModel post = new PostModel(
                            resultSet.getString("PostID"),
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
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return postModelList;
    }
    //tạo 1 bài post mới
    //trả về khi true
    //false khi không thành công
    //
    public boolean CreateNewPost(PostModel newPost){
        String query = "INSERT INTO post(PostID, UserID, Image, Content, DatePost, Modifed, LastModifedTime) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            CheckDrive();
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newPost.PostID);
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
    public PostModel FecthPostModel(String PostID){
        String query = String.format("select * from post where PostID = %s",PostID);
        PostModel postModel = new PostModel(null,null,null,null,null, null,
                null);
        try{
            CheckDrive();
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                PostModel post = new PostModel(
                        resultSet.getString("PostID"),
                        resultSet.getString("UserID"),
                        resultSet.getString("Image"),
                        resultSet.getString("Content"),
                        resultSet.getDate("DatePost").toLocalDate(),
                        resultSet.getDate("Modifed").toLocalDate(),
                        resultSet.getDate("LastModifedTime").toLocalDate()
                );
//                System.out.println("PostID: " + resultSet.getString("PostID"));
//                System.out.println("UserID: " + resultSet.getString("UserID"));
                postModel = post;
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
//        return postModel;
        System.out.println(postModel.PostID);
        return postModel;
    }

    //kiểm tra bài viết có tồn tại hay không.
    public  boolean CheckPostIsExists(String PostID){
        String query = String.format("select  * from post where PostID = %s ",PostID);
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
    //kiểm tra dữ liệu cũ có tồn tại hay không
    //lấy dữ liệu từ bài viết cũ
    //lấy dữ liệu đầu vào cần thay đổi
    //danh sách dữ liệu có thể tay đổi:
    //  nội dung bài viết, hình ảnh.
    public boolean EditPostModel(String PostID, String newContent, String newImages){
        String query = String.format("update post set Image = %s, Content = %s where PostID = %s ",newImages,newContent, PostID);
        var ResultOfCheck = CheckPostIsExists(PostID);
        if(ResultOfCheck == true){
            try{
                connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,newImages);
                preparedStatement.setString(2,newContent);
                preparedStatement.executeUpdate();
                return true;
            }
            catch (SQLException exception){
                exception.printStackTrace();
            }
        }
        return false;
    }
    //kiểm tra dữ liệu có tồn tại hay không
    //tiến hành xóa dữ liệu và trả lại kết quả tiến trình
    public boolean DeletePostModel(String PostID){
        String query = String.format("delete * from post where PostID = %s",PostID);
        try {
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
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
