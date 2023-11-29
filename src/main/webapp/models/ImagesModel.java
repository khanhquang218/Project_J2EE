package models;

import java.time.LocalDate;

public class ImagesModel {
    public String imageID;
    public String imageName;
    public String imageURL;

    public ImagesModel(String imageID, String imageName, String imageURL) {
        this.imageID = imageID;
        this.imageName = imageName;
        this.imageURL = imageURL;
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
}