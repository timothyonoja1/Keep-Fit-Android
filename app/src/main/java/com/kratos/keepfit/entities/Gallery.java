package com.kratos.keepfit.entities;


public class Gallery {

    private final int galleryID;
    private final String uri;
    private final int drawableResource;

    public Gallery(int galleryID, String uri, int drawableResource) {
        this.galleryID = galleryID;
        this.uri = uri;
        this.drawableResource = drawableResource;
    }

    public int getGalleryID() {
        return galleryID;
    }

    public String getUri() {
        return uri;
    }

    public int getDrawableResource() {
        return drawableResource;
    }
}