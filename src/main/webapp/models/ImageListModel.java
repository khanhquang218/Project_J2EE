package models;

import java.time.LocalDate;

public class ImageListModel {
    public int imageListID;
    public String imageID;
    public int PostID;

    public ImageListModel(int imageListID, String imageID, int PostID) {
        this.imageListID = imageListID;
        this.imageID = imageID;
        this.PostID = PostID;
    }

    public int getImageListID() {
        return imageListID;
    }

    public void setImageListID(int imageListID) {
        this.imageListID = imageListID;
    }

    public String getimageID() {
        return imageID;
    }

    public void setimageID(String imageID) {
        this.imageID = imageID;
    }

    public int getPostID() {
        return PostID;
    }

    public void setPostID(int PostID) {
        this.PostID = PostID;
    }
}