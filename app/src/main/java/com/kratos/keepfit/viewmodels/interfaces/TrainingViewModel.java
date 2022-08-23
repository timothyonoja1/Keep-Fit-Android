package com.kratos.keepfit.viewmodels.interfaces;

import androidx.lifecycle.MutableLiveData;
import com.kratos.keepfit.entities.Training;
import com.kratos.keepfit.entities.TrainingSession;
import com.kratos.keepfit.states.TrainingListUiState;
import com.kratos.keepfit.states.TrainingSessionListUiState;
import com.kratos.keepfit.states.TrainingSessionUiState;

public interface TrainingViewModel {

    MutableLiveData<TrainingListUiState> getTrainingListUiState();

    MutableLiveData<TrainingSessionListUiState> getTrainingSessionListUiState();

    MutableLiveData<TrainingSessionUiState> getTrainingSessionUiState();

    void setSelectedTraining(Training training);

    void setSelectedTrainingSession(TrainingSession trainingSession);

}