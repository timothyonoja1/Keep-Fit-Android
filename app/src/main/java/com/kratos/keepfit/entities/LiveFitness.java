package com.kratos.keepfit.entities;

public class LiveFitness {

    private final int liveID;
    private final String name;
    private final String numberOfViews;
    private final String backgroundUri;
    private int backgroundImageDrawableResource;
    private final LiveFitnessDetail liveFitnessDetail;

    public LiveFitness(int liveID, String name, String numberOfViews,
                       String backgroundUri, LiveFitnessDetail liveFitnessDetail) {
        this.liveID = liveID;
        this.name = name;
        this.numberOfViews = numberOfViews;
        this.backgroundUri = backgroundUri;
        this.liveFitnessDetail = liveFitnessDetail;
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

    public String getBackgroundUri() {
        return backgroundUri;
    }

    public int getBackgroundImageDrawableResource() {
        return backgroundImageDrawableResource;
    }

    public void setBackgroundImageDrawableResource(int backgroundImageDrawableResource) {
        this.backgroundImageDrawableResource = backgroundImageDrawableResource;
    }

    public LiveFitnessDetail getLiveFitnessDetail() {
        return liveFitnessDetail;
    }
}