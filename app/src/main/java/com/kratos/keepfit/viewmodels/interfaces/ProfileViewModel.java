package com.kratos.keepfit.viewmodels.interfaces;

import androidx.lifecycle.MutableLiveData;

import com.kratos.keepfit.states.ProfileUiState;

public interface ProfileViewModel {

    MutableLiveData<ProfileUiState> getProfileUiState();

    void logout();
}
