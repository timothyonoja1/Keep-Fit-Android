package com.kratos.keepfit.entities;

public class Upcoming {

    private final int upcomingID;
    private final String name;
    private final String numberOfBookings;
    private final String backgroundUri;
    private final UpcomingDetail upcomingDetail;
    private int backgroundImageDrawableResource;

    public Upcoming(int upcomingID, String name, String numberOfBookings,
                    String backgroundUri, UpcomingDetail upcomingDetail) {
        this.upcomingID = upcomingID;
        this.name = name;
        this.numberOfBookings = numberOfBookings;
        this.backgroundUri = backgroundUri;
        this.upcomingDetail = upcomingDetail;
    }

    public int getUpcomingID() {
        return upcomingID;
    }

    public String getName() {
        return name;
    }

    public String getNumberOfBookings() {
        return numberOfBookings;
    }

    public String getBackgroundUri() {
        return backgroundUri;
    }

    public UpcomingDetail getUpcomingDetail() {
        return upcomingDetail;
    }

    public int getBackgroundImageDrawableResource() {
        return backgroundImageDrawableResource;
    }

    public void setBackgroundImageDrawableResource(int backgroundImageDrawableResource) {
        this.backgroundImageDrawableResource = backgroundImageDrawableResource;
    }
}