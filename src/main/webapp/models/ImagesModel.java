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

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getParentID() {
        return ParentID;
    }

    public void setParentID(String parentID) {
        ParentID = parentID;
    }
}