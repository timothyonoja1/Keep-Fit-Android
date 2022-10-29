package com.kratos.keepfit.viewmodels.fakes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kratos.keepfit.entities.Feed;
import com.kratos.keepfit.entities.Gender;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;
import com.kratos.keepfit.entities.UserRole;
import com.kratos.keepfit.states.FeedListUiState;
import com.kratos.keepfit.viewmodels.interfaces.FeedViewModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FakeFeedViewModel extends ViewModel implements FeedViewModel {

    private final MutableLiveData<FeedListUiState> feedListUiState = new MutableLiveData<>();

    @Override
    public MutableLiveData<FeedListUiState> getFeedListUiState() {
        feedListUiState.setValue(new FeedListUiState(
             false, "Good Morning", getMockUserProfile(),
                getMockUserProfileDetail(), getMockFeeds()
        ));
        return feedListUiState;
    }

    private List<Feed> getMockFeeds() {
        List<Feed> feeds = new ArrayList<>();

        feeds.add(new Feed(1, 1, "Lunges", 10,
                12,  4, "@drawable/lunges"));
        feeds.add(new Feed(2, 2, "Barbell Chest", 5,
                1, 0,  "@drawable/barbell_chest"));

        return feeds;
    }

    private UserProfile getMockUserProfile() {
        return new UserProfile(1, "example@gmail.com", "Daniel",
                "", new Date(), UserRole.Basic);
    }

    private UserProfileDetail getMockUserProfileDetail() {
        return new UserProfileDetail(1, 25, Gender.Male, 280,
                80, "I love God", "Ondo City", "dp_image.jpg",
                "https://www.facebook.com/dp_image.jpg", 0, false, 0, 1, 1,
                1, 1, 1, 1);
    }

}