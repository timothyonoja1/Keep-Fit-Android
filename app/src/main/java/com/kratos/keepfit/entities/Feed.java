package com.kratos.keepfit.entities;

import java.util.Date;

public class Feed {

    private final int feedID;
    private final int exerciseId;
    private final String name;
    private final int durationInMinutes;
    private final int numberOfSessions;
    private final int numberOfWeeksPlan;
    private final String imageUrl;
    private final String details;
    private int drawableResource;
    private Date dateSavedToLocalDatabase;

    public Feed(int feedID, int exerciseId, String name,
                int durationInMinutes, int numberOfSessions,
                int numberOfWeeksPlan, String imageUrl) {
        this.feedID = feedID;
        this.exerciseId = exerciseId;
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.numberOfSessions = numberOfSessions;
        this.numberOfWeeksPlan = numberOfWeeksPlan;
        this.imageUrl = imageUrl;
        details = String.format("%1s mins | %2s Sessions | %3s Week Plan",
                durationInMinutes, numberOfSessions, numberOfWeeksPlan);
    }

    public int getFeedID() {
        return feedID;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public int getNumberOfSessions() {
        return numberOfSessions;
    }

    public int getNumberOfWeeksPlan() {
        return numberOfWeeksPlan;
    }

    public String getDetails() {
        return details;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}