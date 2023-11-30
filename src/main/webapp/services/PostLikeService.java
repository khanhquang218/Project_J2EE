package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostLikeService {
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
    public boolean CreatePostPost(String ParentID, String PostLikeID,String UserID){
        String query =  String.format("insert into postlike(PostLikeID, PostID, UserID, Count) " +
                "value (?,?,?,?)");

        try{
            Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,PostLikeID);
            preparedStatement.setString(2,ParentID);
            preparedStatement.setString(3,UserID);
            preparedStatement.setString(4,String.valueOf(0));
            preparedStatement.executeUpdate();
            return true;
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return false;
    }
}
