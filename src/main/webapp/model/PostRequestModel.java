package model;

import java.time.LocalDate;

public class PostRequestModel {
    public String PostID;
    public String UserID;
    public String Image;
    public String Content;
    public LocalDate DatePost;
    public LocalDate Modifed;
    public LocalDate LastModifedTime;
    public PostRequestModel(String postID, String userID, String image, String content,
                            LocalDate datePost, LocalDate modifed, LocalDate lastModifedTime){
        this.PostID = postID;
        this.DatePost = datePost;
        this.Content = content;
        this.Image = image;
        this.Modifed = modifed;
        this.LastModifedTime = lastModifedTime;
        this.UserID = userID;
    }
//    public String getPostID(){
//        return this.PostID;
//    }
//    public String getUserID(){
//        return  this.UserID;
//    }
//    public  String getImage(){
//        return  this.Image;
//    }
//    public String getContent(){
//        return  this.Content;
//    }
//    public LocalDate getDatePost(){
//        return  this.DatePost;
//    }
//    public LocalDate getModified(){
//        return  this.Modified;
//    }
//    public LocalDate getLastModifiedTime(){
//        return  this.LastModifiedTime;
//    }
//    public void setPostID(String PostID){
//        this.PostID = PostID;
//    }
}
