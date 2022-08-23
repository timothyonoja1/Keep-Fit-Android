package com.kratos.keepfit.entities;

public class Training {

    private final int trainingID;
    private final String title;
    private final String author;
    private final String dateTime;
    private final String numberOfSessions;
    private final String numberOfWeeks;
    private final String notes;
    private final String imageUri;

    public Training(int trainingID, String title, String author, String dateTime,
                    String numberOfSessions, String numberOfWeeks, String notes, String imageUri) {
        this.trainingID = trainingID;
        this.title = title;
        this.author = author;
        this.dateTime = dateTime;
        this.numberOfSessions = numberOfSessions;
        this.numberOfWeeks = numberOfWeeks;
        this.notes = notes;
        this.imageUri = imageUri;
    }

    public int getTrainingID() {
        return trainingID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getNumberOfSessions() {
        return numberOfSessions;
    }

    public String getNumberOfWeeks() {
        return numberOfWeeks;
    }

    public String getImageUri() {
        return imageUri;
    }

    public String getNotes() {
        return notes;
    }
}