package com.kratos.keepfit.entities;

public class Notification {

    private final int notificationID;
    private final String displayText;
    private final String message;
    private final String postedDate;
    private final int drawableResource;

    public Notification(int notificationID, String displayText,
                        String message, String postedDate, int drawableResource) {
        this.notificationID = notificationID;
        this.displayText = displayText;
        this.message = message;
        this.postedDate = postedDate;
        this.drawableResource = drawableResource;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public String getDisplayText() {
        return displayText;
    }

    public String getMessage() {
        return message;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public int getDrawableResource() {
        return drawableResource;
    }
}