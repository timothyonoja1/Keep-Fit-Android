package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.Training;
import com.kratos.keepfit.entities.TrainingSession;

import java.util.List;

public class TrainingSessionListUiState {

    private final boolean fetchingTrainingSectionList;
    private final Training selectedTraining;
    private final List<TrainingSession> trainingSessionList;

    public TrainingSessionListUiState(boolean fetchingTrainingSectionList, Training selectedTraining,
                                      List<TrainingSession> trainingSessionList) {
        this.fetchingTrainingSectionList = fetchingTrainingSectionList;
        this.selectedTraining = selectedTraining;
        this.trainingSessionList = trainingSessionList;
    }

    public boolean isFetchingTrainingSectionList() {
        return fetchingTrainingSectionList;
    }

    public Training getSelectedTraining() {
        return selectedTraining;
    }

    public List<TrainingSession> getTrainingSessionList() {
        return trainingSessionList;
    }
}