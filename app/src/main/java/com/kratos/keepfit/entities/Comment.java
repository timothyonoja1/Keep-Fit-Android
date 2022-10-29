package com.kratos.keepfit.entities;

import java.util.Date;

public class Comment {

    private final int commentID;
    private final String message;
    private final int senderUserProfileID;
    private final int receiverUserProfileID;
    private Date dateSavedToLocalDatabase;

    public Comment(int commentID, String message,
                   int senderUserProfileID,
                   int receiverUserProfileID) {
        this.commentID = commentID;
        this.message = message;
        this.senderUserProfileID = senderUserProfileID;
        this.receiverUserProfileID = receiverUserProfileID;
    }

    public int getCommentID() {
        return commentID;
    }

    public String getMessage() {
        return message;
    }

    public int getSenderUserProfileID() {
        return senderUserProfileID;
    }

    public int getReceiverUserProfileID() {
        return receiverUserProfileID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
