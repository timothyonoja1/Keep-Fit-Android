package com.kratos.keepfit.viewmodels.interfaces;

import androidx.lifecycle.MutableLiveData;
import com.kratos.keepfit.states.HomeUiState;

public interface HomeViewModel {

    MutableLiveData<HomeUiState> getHomeUiState();

}