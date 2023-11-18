package model;

import java.time.LocalDate;

public class PostRequestModel {
    public String PostID;
    public String UserID;
    public String Image;
    public String Contect;
    public LocalDate DatePost;
    public LocalDate Modifed;
    public LocalDate LastModifedTime;
    public PostRequestModel(String postID, String userID, String image, String contect,
                            LocalDate datePost, LocalDate modifed, LocalDate lastModifedTime){
        this.PostID = postID;
        this.DatePost = datePost;
        this.Contect = contect;
        this.Image = image;
        this.Modifed = modifed;
        this.LastModifedTime = lastModifedTime;
        this.UserID = userID;
    }

}
