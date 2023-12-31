package services;

import models.FriendshipModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FriendshipService {
    private static final Configura configura = new Configura();
    public boolean CreateRelationship(FriendshipModel newFriendship) {
        UserServices userServices = new UserServices();
        var ResultOfCheckUserID1 = userServices.CheckUserIsExists(newFriendship.UserID1);
        var ResultOfCheckUserID2 = userServices.CheckUserIsExists(newFriendship.UserID2);

        if (ResultOfCheckUserID1 && ResultOfCheckUserID2) {
            String query = "INSERT INTO friendship (FriendShipID, UserID1, UserID2, AcceptDate,Friend) VALUES (?, ?, ?, ?,?)";

            try {
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, newFriendship.FriendshipID);
                preparedStatement.setString(2, newFriendship.UserID1);
                preparedStatement.setString(3, newFriendship.UserID2);
                preparedStatement.setDate(4, Date.valueOf(newFriendship.AcceptDate));
                preparedStatement.setBoolean(5,newFriendship.Friend);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }

    public List<FriendshipModel> GetAllFriendShipOfUser(String UserID){
        UserServices userServices = new UserServices();
        var ResultOfCheck = userServices.CheckUserIsExists(UserID);
        List<FriendshipModel> friendshipModelList = new ArrayList<>();
        String query = String.format("select * from friendship where UserId1 = %s and Friend = true", UserID);
        if (ResultOfCheck){
            try{
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    FriendshipModel friendshipModel = new FriendshipModel(
                            resultSet.getString("FriendShipID"),
                            resultSet.getString("UserID1"),
                            resultSet.getString("UserID2"),
                            resultSet.getDate("AcceptDate").toLocalDate(),
                            resultSet.getBoolean("Friend")
                    );
                    friendshipModelList.add(friendshipModel);
                }
            }
            catch (SQLException exception){
                exception.printStackTrace();
            }
            return friendshipModelList;
        }
        return null;
    }
    public boolean DeleteARelationship (String UserID1, String UserID2){
        UserServices userServices = new UserServices();
        var resultOfCheck1 = userServices.CheckUserIsExists(UserID1);
        var resultOfCheck2 = userServices.CheckUserIsExists(UserID2);
        String query = String.format("delete from friendship where UserID1 = '%s' and UserID2 = '%s' and Friend = true", UserID1, UserID2);
        if(resultOfCheck2 == true || resultOfCheck1 == true){
            try{
                Configura.CheckDrive();
                Connection connection = DriverManager.getConnection(configura.JDBC_URL, configura.JDBC_USER, configura.JDBC_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();
                return true;
            }
            catch (SQLException exception){
                exception.printStackTrace();
            }
            return false;
        }
        return false;
    }
}
