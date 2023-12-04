package models;

public class ReplyToModel {
    public int ParentID;
    public int ReplyID;
    public int Levels;
    public String Content;
    public ReplyToModel(int replyID, int parentID, int levels, String content){
        this.ReplyID = replyID;
        this.ParentID = parentID;
        this.Levels = levels;
        this.Content = content;
    }

    public int getLevels() {
        return Levels;
    }

    public int getParentID() {
        return ParentID;
    }

    public int getReplyID() {
        return ReplyID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void setLevels(int levels) {
        Levels = levels;
    }

    public void setParentID(int parentID) {
        ParentID = parentID;
    }

    public void setReplyID(int replyID) {
        ReplyID = replyID;
    }
}
