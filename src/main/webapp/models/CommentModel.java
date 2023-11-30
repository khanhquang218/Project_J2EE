package models;


import java.time.LocalDate;

public class CommentModel {
    public String CommentID;
    public String Content;
    public String PostID;
    public String ReplyTo;
    public String UserID;
    public LocalDate CreateDate;
    public CommentModel(String CommentID, String Content, String PostID, String ReplyTo,String UserID, LocalDate CreateDate){
        this.CommentID = CommentID;
        this.Content = Content;
        this.PostID = PostID;
        this.ReplyTo = ReplyTo;
        this.UserID = UserID;
        this.CreateDate = CreateDate;
    }

    public String getCommentID() {
        return CommentID;
    }

    public void setCommentID(String CommentID) {
        this.CommentID = CommentID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getPostID() {
        return PostID;
    }

    public void setPostID(String PostID) {
        this.PostID = PostID;
    }

    public String getReplyTo() {
        return ReplyTo;
    }

    public void setReplyTo(String ReplyTo) {
        this.ReplyTo = ReplyTo;
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
}