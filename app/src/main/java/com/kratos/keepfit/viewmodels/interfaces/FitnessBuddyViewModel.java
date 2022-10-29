package com.kratos.keepfit.viewmodels.interfaces;

import androidx.lifecycle.MutableLiveData;

import com.kratos.keepfit.states.FitnessBuddyAccountUiState;
import com.kratos.keepfit.states.FitnessBuddyUiState;

public interface FitnessBuddyViewModel {

    MutableLiveData<FitnessBuddyUiState> getFitnessBuddyUiState();

    MutableLiveData<FitnessBuddyAccountUiState> getFitnessBuddyAccountUiState();

    void addFitnessBuddy(int fitnessBuddyID);

    void setSelectedFitnessBuddy(int fitnessBuddyID, int userProfileIDofSelectedFitnessBuddy);

}
