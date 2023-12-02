package models;

import java.time.LocalDate;

public class FriendshipModel {
    public String FriendshipID;
    public String UserID1;
    public String UserID2;
    public LocalDate AcceptDate;
    public boolean Friend;
    public FriendshipModel(String FriendshipID, String UserID1, String UserID2, LocalDate AcceptDate, boolean Friend){
        this.FriendshipID = FriendshipID;
        this.UserID1 = UserID1;
        this.UserID2 = UserID2;
        this.AcceptDate = AcceptDate;
        this.Friend = Friend;
    }

    public String getFriendship() {
        return FriendshipID;
    }

    public void setFriendship(String friendship) {
        this.FriendshipID = FriendshipID;
    }

    public String getUserID1() {
        return UserID1;
    }

    public void setUserID1(String userID1) {
        this.UserID1 = UserID1;
    }

    public String getUserID2() {
        return UserID2;
    }

    public void setUserID2(String userID1) {
        this.UserID2 = UserID2;
    }

    public LocalDate getAcceptDate() {
        return AcceptDate;
    }

    public void setAcceptDate(LocalDate AcceptDate) {
        this.AcceptDate = AcceptDate;
    }

    public boolean getFriend(){ return Friend;}

    public void setFriend(Boolean Friend) {this.Friend = Friend;}
}