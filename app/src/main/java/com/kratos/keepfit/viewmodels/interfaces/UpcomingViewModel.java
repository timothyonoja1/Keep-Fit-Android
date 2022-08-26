package com.kratos.keepfit.viewmodels.interfaces;

import androidx.lifecycle.MutableLiveData;
import com.kratos.keepfit.entities.Upcoming;
import com.kratos.keepfit.states.UpcomingItemUiState;
import com.kratos.keepfit.states.UpcomingListUiState;

public interface UpcomingViewModel {
    
    MutableLiveData<UpcomingListUiState> getUpcomingListUiState();
    
    MutableLiveData<UpcomingItemUiState> getUpcomingItemUiState();
    
    void setSelectedUpcomingItem(Upcoming upcomingItem);

}
