package com.kratos.keepfit.viewmodels.interfaces;

import androidx.lifecycle.MutableLiveData;
import com.kratos.keepfit.states.FeedListUiState;

public interface FeedViewModel {

    MutableLiveData<FeedListUiState> getFeedListUiState();

}