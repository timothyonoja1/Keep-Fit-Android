package com.kratos.keepfit.core;

import android.graphics.drawable.Drawable;

public class LiveFitness {

    private final int liveID;
    private final String name;
    private final String numberOfViews;
    private final Drawable backgroundImage;

    public LiveFitness(int liveID, String name, String numberOfViews, Drawable backgroundImage) {
        this.liveID = liveID;
        this.name = name;
        this.numberOfViews = numberOfViews;
        this.backgroundImage = backgroundImage;
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

    public Drawable getBackgroundImage() {
        return backgroundImage;
    }
}
