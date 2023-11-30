package services;

import models.FriendshipModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FriendshipService {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/j2ee";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";
    public boolean CreateRelationship (FriendshipModel newRelationShip){
        String query =  String.format("insert into friendship(FriendshipID, UserID1, UserID2, RequestDate, ApproveDate,DeniedDate) " +
                "value (?,?,?,?,?,?)");
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,newRelationShip.FriendshipID);
            preparedStatement.setString(2,newRelationShip.UserID1);
            preparedStatement.setString(3,newRelationShip.UserID2);
            preparedStatement.setString(4,String.valueOf(newRelationShip.RequestDate));
            preparedStatement.setString(5,String.valueOf(newRelationShip.ApproveDate));
            preparedStatement.setString(6,String.valueOf(newRelationShip.DeniedDate));
            preparedStatement.executeUpdate();
            return true;
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return false;
    }
    public List<FriendshipModel> GetAllRelationship(){
        String query = "select * from friendship";
        List<FriendshipModel> friendshipModelList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                FriendshipModel friendshipModel = new FriendshipModel(
                        resultSet.getString("PostLikeID"),
                        resultSet.getString("UserID1"),
                        resultSet.getString("UserID2"),
                        resultSet.getDate("RequestDate").toLocalDate(),
                        resultSet.getDate("ApproveDate").toLocalDate(),
                        resultSet.getDate("DeniedDate").toLocalDate()
                );
                friendshipModelList.add(friendshipModel);
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return  friendshipModelList;
    }
}
