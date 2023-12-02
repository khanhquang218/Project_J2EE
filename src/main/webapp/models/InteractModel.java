package models;

import java.time.LocalDate;

public class InteractModel {
    public String InteractID;
    public int ParentID;
    public String UserID;
    public int Count;

    public InteractModel(String InteractID, int ParentID, String userID, int count) {
        this.InteractID = InteractID;
        this.ParentID = ParentID;
        this.UserID = userID;
        this.Count = count;
    }

    public String getInteractID() {
        return InteractID;
    }

    public void setInteractID(String InteractID) {
        this.InteractID = InteractID;
    }

    public int getParentID() {
        return ParentID;
    }

    public void setParentID(int ParentID) {
        this.ParentID = ParentID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }
    
    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        this.Count = Count;
    }
}