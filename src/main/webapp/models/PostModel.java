package models;

import java.time.LocalDate;

public class PostModel {
    public int PostID;
    public String UserID;
    public String Image;
    public String Content;
    public LocalDate DatePost;
    public LocalDate Modifed;
    public LocalDate LastModifedTime;
    public PostModel(int postID, String userID, String image, String content,
                     LocalDate datePost, LocalDate modifed, LocalDate lastModifedTime){
        this.PostID = postID;
        this.DatePost = datePost;
        this.Content = content;
        this.Image = image;
        this.Modifed = modifed;
        this.LastModifedTime = lastModifedTime;
        this.UserID = userID;
    }
    public int getPostID(){
        return this.PostID;
    }
    public String getUserID(){
        return  this.UserID;
    }
    public  String getImage(){
        return  this.Image;
    }
    public String getContent(){
        return  this.Content;
    }
    public LocalDate getDatePost(){
        return  this.DatePost;
    }
    public LocalDate getModified(){
        return  this.Modifed;
    }
    public LocalDate getLastModifiedTime(){
        return  this.LastModifedTime;
    }
    public void setPostID(int PostID){
        this.PostID = PostID;
    }
    public void setUserID(String UserID){
        this.UserID = UserID;
    }
    public void setImage(String Image){
        this.Image = Image;
    }
    public void setContent(String Content){
        this.Content = Content;
    }
    public void setDatePost(LocalDate DatePost){
        this.DatePost = DatePost;
    }
    public void setModifed(LocalDate Modifed){
        this.Modifed = Modifed;
    }
    public void setLastModifedTime(LocalDate lastModifedTime){
        this.LastModifedTime = lastModifedTime;
    }
}