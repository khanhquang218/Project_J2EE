package models;


import java.time.LocalDate;

public class CommentModel {
    public int CommentID;
    public String Content;
    public int ParentID;
    public int PostID;
    public String UserID;
    public LocalDate CreateDate;
    public int Levels;
    public CommentModel(int CommentID, String Content, int ParentID, int PostID,String UserID,
                        LocalDate CreateDate, int Levels){
        this.CommentID = CommentID;
        this.Content = Content;
        this.ParentID = ParentID;
        this.PostID = PostID;
        this.UserID = UserID;
        this.CreateDate = CreateDate;
        this.Levels = Levels;
    }

    public int getCommentID() {
        return CommentID;
    }

    public void setCommentID(Integer CommentID) {
        this.CommentID = CommentID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public int getParentID() { return ParentID;}

    public void setParentID(int ParentID) { this.ParentID = ParentID;}

    public int getPostID() {
        return PostID;
    }

    public void setPostID(int PostID) {
        this.PostID = PostID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public LocalDate CreateDate() {
        return CreateDate;
    }

    public void CreateDate(LocalDate CreateDate) {
        this.CreateDate = CreateDate;
    }

    public int getLevels() {
        return Levels;
    }

    public void setLevels(int Levels) {
        this.Levels = Levels;
    }
}