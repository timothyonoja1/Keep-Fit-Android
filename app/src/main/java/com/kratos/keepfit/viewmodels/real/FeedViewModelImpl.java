package com.kratos.keepfit.viewmodels.real;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kratos.keepfit.entities.Feed;
import com.kratos.keepfit.repositories.interfaces.UserRepository;
import com.kratos.keepfit.states.FeedListUiState;
import com.kratos.keepfit.utilities.interfaces.DateTimeUtility;
import com.kratos.keepfit.viewmodels.interfaces.FeedViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class FeedViewModelImpl extends ViewModel implements FeedViewModel {

    private final UserRepository userRepository;
    private final DateTimeUtility dateTimeUtility;
    private final Executor executor;
    public final MutableLiveData<FeedListUiState> feedListUiState;
    
    @Inject
    public FeedViewModelImpl(UserRepository userRepository,
                             DateTimeUtility dateTimeUtility, Executor executor) {
        this.userRepository = userRepository;
        this.dateTimeUtility = dateTimeUtility;
        this.executor = executor;
        feedListUiState = new MutableLiveData<>();
    }
    
    
    @Override
    public MutableLiveData<FeedListUiState> getFeedListUiState() {
        feedListUiState.setValue(new FeedListUiState(true,
                dateTimeUtility.getAppropriateGreeting(), null, null,
                new ArrayList<>()
        ));
        executor.execute(() -> {
            feedListUiState.postValue(new FeedListUiState(true,
                    dateTimeUtility.getAppropriateGreeting(), null, null,
                    new ArrayList<>()
            ));
            feedListUiState.postValue(new FeedListUiState(false,
                    dateTimeUtility.getAppropriateGreeting(),
                    userRepository.getLoggedInUserProfileSync(),
                    userRepository.getLoggedInUserProfileDetailSync(),
                    new ArrayList<>()
            ));
        });
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
}
