package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.Feed;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;
import java.util.List;

public class FeedListUiState {
    private final boolean fetchingFeedList;
    private final String appropriateGreeting;
    private final UserProfile userProfile;
    private final UserProfileDetail userProfileDetail;
    private final List<Feed> feeds;

    public FeedListUiState(boolean fetchingFeedList, String appropriateGreeting,
                           UserProfile userProfile, UserProfileDetail userProfileDetail, List<Feed> feeds) {
        this.fetchingFeedList = fetchingFeedList;
        this.appropriateGreeting = appropriateGreeting;
        this.userProfile = userProfile;
        this.userProfileDetail = userProfileDetail;
        this.feeds = feeds;
    }

    public boolean isFetchingFeedList() {
        return fetchingFeedList;
    }

    public String getAppropriateGreeting() {
        return appropriateGreeting;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public UserProfileDetail getUserProfileDetail() {
        return userProfileDetail;
    }

    public List<Feed> getFeeds() {
        return feeds;
    }
}
