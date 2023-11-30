package models;

import java.time.LocalDate;

public class FriendshipModel {
    public String FriendshipID;
    public String UserID1;
    public String UserID2;
    public LocalDate RequestDate;
    public LocalDate ApproveDate;
    public LocalDate DeniedDate;
    
    public FriendshipModel(String FriendshipID, String UserID1, String UserID2, LocalDate RequestDate, LocalDate ApproveDate, LocalDate DeniedDate){
        this.FriendshipID = FriendshipID;
        this.UserID1 = UserID1;
        this.UserID2 = UserID2;
        this.RequestDate = RequestDate;
        this.ApproveDate = ApproveDate;
        this.DeniedDate = DeniedDate;
    }

    public String getFriendship() {
        return FriendshipID;
    }

    public void setFriendship(String friendship) {
        this.FriendshipID = friendship;
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

    public LocalDate RequestDate() {
        return RequestDate;
    }

    public void RequestDate(LocalDate RequestDate) {
        this.RequestDate = RequestDate;
    }

    public LocalDate approveDate() {
        return ApproveDate;
    }

    public void approveDate(LocalDate approveDate) {
        this.ApproveDate = approveDate;
    }

    public LocalDate DeniedDate() {
        return DeniedDate;
    }

    public void DeniedDate(LocalDate DeniedDate) {
        this.DeniedDate = DeniedDate;
    }
}