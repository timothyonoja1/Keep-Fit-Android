package com.kratos.keepfit.entities;

public class TrainingSession {

    private final int trainingSectionID;
    private final int trainingID;
    private int drawableResource;
    private final String imageUri;
    private final String title;
    private final String description;
    private final boolean isFavorite;

    public TrainingSession(int trainingSectionID, int trainingID, String imageUri,
                           String title, String description, boolean isFavorite) {
        this.trainingSectionID = trainingSectionID;
        this.trainingID = trainingID;
        this.imageUri = imageUri;
        this.title = title;
        this.description = description;
        this.isFavorite = isFavorite;
    }

    public int getTrainingSectionID() {
        return trainingSectionID;
    }

    public int getTrainingID() {
        return trainingID;
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
}