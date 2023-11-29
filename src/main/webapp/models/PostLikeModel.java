package models;

import java.time.LocalDate;

public class PostLikeModel {
    public String PostLikeID;
    public String PostID;
    public String UserID;
    public int Count;

    public PostLikeModel(String PostLikeID, String postID, String userID, int count) {
        this.PostLikeID = postID;
        this.PostID = postID;
        this.UserID = userID;
        this.Count = count;
    }

    public String getPostLikeID() {
        return PostLikeID;
    }

    public void setPostLikeID(String postID) {
        this.PostLikeID = postID;
    }

    public String getPostID() {
        return PostID;
    }

    public void setPostID(String postID) {
        this.PostID = postID;
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