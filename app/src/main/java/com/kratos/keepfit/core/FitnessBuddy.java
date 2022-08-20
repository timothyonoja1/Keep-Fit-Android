package com.kratos.keepfit.core;

public class FitnessBuddy {

    private final String name;
    private final String location;
    private final String category;
    private final String description;
    private final int drawableResource;

    public FitnessBuddy(String name, String location, String category, String description, int drawableResource) {
        this.name = name;
        this.location = location;
        this.category = category;
        this.description = description;
        this.drawableResource = drawableResource;
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

    public int getDrawableResource() {
        return drawableResource;
    }
}