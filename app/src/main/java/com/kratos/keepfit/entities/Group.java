package com.kratos.keepfit.entities;

public class Group {

    private final int GalleryID;
    private final int imageIconDrawableResource;
    private final String name;
    private final String status;
    private final String time;

    public Group(int galleryID, int imageIconDrawableResource,
                 String name, String status, String time) {
        GalleryID = galleryID;
        this.imageIconDrawableResource = imageIconDrawableResource;
        this.name = name;
        this.status = status;
        this.time = time;
    }

    public int getGalleryID() {
        return GalleryID;
    }

    public int getImageIconDrawableResource() {
        return imageIconDrawableResource;
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
