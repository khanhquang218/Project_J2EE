package services;

import models.PostModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public PostModel CreatePost(PostModel newPost){
        
    }
}
