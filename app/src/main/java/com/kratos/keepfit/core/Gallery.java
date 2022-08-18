package com.kratos.keepfit.core;

import android.graphics.drawable.Drawable;

public class Gallery {

    private final int galleryID;
    private final String uri;
    private final Drawable drawableResource;

    public Gallery(int galleryID, String uri, Drawable drawableResource) {
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

    public Drawable getDrawableResource() {
        return drawableResource;
    }
}