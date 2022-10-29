package com.kratos.keepfit.entities;

public class UnrelatedFitnessBuddy {

    private final int fitnessBuddyID;
    private final int userProfileID;
    private final String name;
    private final String location;
    private final String category;
    private final String description;
    private final String imageUrl;
    private int drawableResource;

    public UnrelatedFitnessBuddy(int fitnessBuddyID, int userProfileID, String name, String location,
                                 String category, String description,
                                 String imageUrl) {
        this.fitnessBuddyID = fitnessBuddyID;
        this.userProfileID = userProfileID;
        this.name = name;
        this.location = location;
        this.category = category;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public int getFitnessBuddyID() {
        return fitnessBuddyID;
    }

    public int getUserProfileID() {
        return userProfileID;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }
}