package com.kratos.keepfit.viewmodels.interfaces;

import androidx.lifecycle.MutableLiveData;
import com.kratos.keepfit.entities.LiveFitness;
import com.kratos.keepfit.states.LiveFitnessListUiState;
import com.kratos.keepfit.states.LiveFitnessItemUiState;

public interface LiveFitnessViewModel {

    MutableLiveData<LiveFitnessListUiState> getLiveFitnessListUiState();

    MutableLiveData<LiveFitnessItemUiState> getLiveFitnessItemUiState();

    void setSelectedLiveFitness(LiveFitness liveFitness);
}
