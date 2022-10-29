package com.kratos.keepfit.entities;

public class UpcomingDetail {

    private final String dateTime;
    private final String authorName;
    private final String keyInformation;
    private final String expectedResult;
    private final String authorImageUri;
    private final String backgroundImageUri;

    public UpcomingDetail(String dateTime, String authorName,
                          String keyInformation, String expectedResult,
                          String authorImageUri, String backgroundImageUri) {
        this.dateTime = dateTime;
        this.authorName = authorName;
        this.keyInformation = keyInformation;
        this.expectedResult = expectedResult;
        this.authorImageUri = authorImageUri;
        this.backgroundImageUri = backgroundImageUri;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getKeyInformation() {
        return keyInformation;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String getAuthorImageUri() {
        return authorImageUri;
    }

    public String getBackgroundImageUri() {
        return backgroundImageUri;
    }

}