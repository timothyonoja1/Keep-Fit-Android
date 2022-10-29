package com.kratos.keepfit.entities;


import androidx.room.Entity;
import java.util.Date;

@Entity
public class Gallery {

    private final int galleryID;
    private final String imageUri;
    private final String videoUri;
    private final int userProfileID;
    private Date dateSavedToLocalDatabase;

    public Gallery(int galleryID, String imageUri, String videoUri, int userProfileID) {
        this.galleryID = galleryID;
        this.imageUri = imageUri;
        this.videoUri = videoUri;
        this.userProfileID = userProfileID;
    }

    public int getGalleryID() {
        return galleryID;
    }

    public String getImageUri() {
        return imageUri;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public int getUserProfileID() {
        return userProfileID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}