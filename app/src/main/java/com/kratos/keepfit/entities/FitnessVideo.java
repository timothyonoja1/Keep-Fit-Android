package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class FitnessVideo {

    private final int fitnessVideoID;
    private final int fitnessProgrammeID;
    private int drawableResource;
    private final String imageUri;
    private final String videoUrl;
    private final String title;
    private final String description;
    private final boolean isFavorite;
    private final int averageStarRating;
    private final int sessionTimeInMinutes;
    private Date dateSavedToLocalDatabase;

    public FitnessVideo(int fitnessVideoID, int fitnessProgrammeID, String imageUri,
                        String videoUrl, String title, String description,
                        boolean isFavorite, int averageStarRating, int sessionTimeInMinutes) {
        this.fitnessVideoID = fitnessVideoID;
        this.fitnessProgrammeID = fitnessProgrammeID;
        this.imageUri = imageUri;
        this.videoUrl = videoUrl;
        this.title = title;
        this.description = description;
        this.isFavorite = isFavorite;
        this.averageStarRating = averageStarRating;
        this.sessionTimeInMinutes = sessionTimeInMinutes;
    }

    public int getFitnessVideoID() {
        return fitnessVideoID;
    }

    public int getFitnessProgrammeID() {
        return fitnessProgrammeID;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public String getImageUri() {
        return imageUri;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public int getAverageStarRating() {
        return averageStarRating;
    }

    public int getSessionTimeInMinutes() {
        return sessionTimeInMinutes;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}