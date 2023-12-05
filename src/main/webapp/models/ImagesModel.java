package models;

import java.time.LocalDate;

public class ImagesModel {
    public String imageID;
    public String imageName;
    public String imageURL;
    public String ParentID;

    public ImagesModel(String imageID, String imageName, String imageURL, String ParentID) {
        this.imageID = imageID;
        this.imageName = imageName;
        this.imageURL = imageURL;
        this.ParentID = ParentID;
    }

    public String getimageID() {
        return imageID;
    }

    public void setimageID(String imageID) {
        this.imageID = imageID;
    }

    public String getimageName() {
        return imageName;
    }

    public void setimageName(String imageName) {
        this.imageName = imageName;
    }

    public String getimageURL() {
        return imageURL;
    }

    public void setimageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String ParentID() {
        return ParentID;
    }

    public void setParentID(String ParentID) {
        this.ParentID = ParentID;
    }
}