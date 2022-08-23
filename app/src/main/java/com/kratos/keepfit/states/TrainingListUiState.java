package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.Training;
import java.util.List;

public class TrainingListUiState {

    private final boolean fetchingTrainingLists;
    private final List<Training> trainingList;

    public TrainingListUiState(boolean fetchingTrainingLists, List<Training> trainingList) {
        this.fetchingTrainingLists = fetchingTrainingLists;
        this.trainingList = trainingList;
    }

    public boolean isFetchingTrainingLists() {
        return fetchingTrainingLists;
    }

    public List<Training> getTrainingList() {
        return trainingList;
    }
}