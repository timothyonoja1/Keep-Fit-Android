package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class FitnessProgramme {

    private final int fitnessProgrammeID;
    private final String title;
    private final String author;
    private final String dateTime;
    private final String numberOfSessions;
    private final String numberOfWeeks;
    private final String note;
    private final String imageUri;
    private final int fitnessCategoryID;
    private Date dateSavedToLocalDatabase;

    public FitnessProgramme(int fitnessProgrammeID, String title, String author, String dateTime,
                            String numberOfSessions, String numberOfWeeks, String note, String imageUri, int fitnessCategoryID) {
        this.fitnessProgrammeID = fitnessProgrammeID;
        this.title = title;
        this.author = author;
        this.dateTime = dateTime;
        this.numberOfSessions = numberOfSessions;
        this.numberOfWeeks = numberOfWeeks;
        this.note = note;
        this.imageUri = imageUri;
        this.fitnessCategoryID = fitnessCategoryID;
    }

    public int getFitnessProgrammeID() {
        return fitnessProgrammeID;
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

    public String getNote() {
        return note;
    }

    public int getFitnessCategoryID() {
        return fitnessCategoryID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}