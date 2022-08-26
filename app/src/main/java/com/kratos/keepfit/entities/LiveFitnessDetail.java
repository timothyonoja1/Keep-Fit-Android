package com.kratos.keepfit.entities;

public class LiveFitnessDetail {

    private final String authorImageUri;
    private final String backgroundImageUri;
    private final String authorName;
    private final String itemName;
    private final String description;
    private final String streamingUser1ImageUri;
    private final String streamingUser2ImageUri;
    private final String numberOfStreamers;
    private int authorDrawableResource;
    private int backgroundDrawableResource;
    private int streamingUser1DrawableResource;
    private int streamingUser2DrawableResource;

    public LiveFitnessDetail(String authorImageUri, String backgroundImageUri, String authorName, String itemName,
                             String description, String streamingUser1ImageUri,
                             String streamingUser2ImageUri, String numberOfStreamers) {
        this.authorImageUri = authorImageUri;
        this.backgroundImageUri = backgroundImageUri;
        this.authorName = authorName;
        this.itemName = itemName;
        this.description = description;
        this.streamingUser1ImageUri = streamingUser1ImageUri;
        this.streamingUser2ImageUri = streamingUser2ImageUri;
        this.numberOfStreamers = numberOfStreamers;
    }

    public String getAuthorImageUri() {
        return authorImageUri;
    }

    public String getBackgroundImageUri() {
        return backgroundImageUri;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public String getStreamingUser1ImageUri() {
        return streamingUser1ImageUri;
    }

    public String getStreamingUser2ImageUri() {
        return streamingUser2ImageUri;
    }

    public String getNumberOfStreamers() {
        return numberOfStreamers;
    }

    public int getAuthorDrawableResource() {
        return authorDrawableResource;
    }

    public int getBackgroundDrawableResource() {
        return backgroundDrawableResource;
    }

    public int getStreamingUser1DrawableResource() {
        return streamingUser1DrawableResource;
    }

    public int getStreamingUser2DrawableResource() {
        return streamingUser2DrawableResource;
    }

    public void setAuthorDrawableResource(int authorDrawableResource) {
        this.authorDrawableResource = authorDrawableResource;
    }

    public void setBackgroundDrawableResource(int backgroundDrawableResource) {
        this.backgroundDrawableResource = backgroundDrawableResource;
    }

    public void setStreamingUser1DrawableResource(int streamingUser1DrawableResource) {
        this.streamingUser1DrawableResource = streamingUser1DrawableResource;
    }

    public void setStreamingUser2DrawableResource(int streamingUser2DrawableResource) {
        this.streamingUser2DrawableResource = streamingUser2DrawableResource;
    }
}