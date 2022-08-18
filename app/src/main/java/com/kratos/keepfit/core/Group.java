package com.kratos.keepfit.core;

import android.graphics.drawable.Drawable;

public class Group {

    private final int GalleryID;
    private final Drawable imageIcon;
    private final String name;
    private final String status;
    private final String time;

    public Group(int galleryID, Drawable imageIcon,
                 String name, String status, String time) {
        GalleryID = galleryID;
        this.imageIcon = imageIcon;
        this.name = name;
        this.status = status;
        this.time = time;
    }

    public int getGalleryID() {
        return GalleryID;
    }

    public Drawable getImageIcon() {
        return imageIcon;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }
}
