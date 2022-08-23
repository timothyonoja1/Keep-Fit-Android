package com.kratos.keepfit.entities;

public class LiveFitness {

    private final int liveID;
    private final String name;
    private final String numberOfViews;
    private final int backgroundImageDrawableResource;

    public LiveFitness(int liveID, String name, String numberOfViews, int backgroundImageDrawableResource) {
        this.liveID = liveID;
        this.name = name;
        this.numberOfViews = numberOfViews;
        this.backgroundImageDrawableResource = backgroundImageDrawableResource;
    }

    public int getLiveID() {
        return liveID;
    }

    public String getName() {
        return name;
    }

    public String getNumberOfViews() {
        return numberOfViews;
    }

    public int getbackgroundImageDrawableResource() {
        return backgroundImageDrawableResource;
    }
}