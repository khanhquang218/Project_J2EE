package models;


import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;

public class CommentModel {
    public int CommentID;
    public String Content;
    public String UserID;
    public int PostID;
    public LocalDate CreateDate;
    public CommentModel(int CommentID, String Content, String UserID, int PostID,
                        LocalDate CreateDate){
        this.CommentID = CommentID;
        this.Content = Content;
        this.UserID = UserID;
        this.PostID = PostID;
        this.CreateDate = CreateDate;
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

    public int getPostID() {return PostID;}

    public void setPostID(int PostID) {this.PostID = PostID;}

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