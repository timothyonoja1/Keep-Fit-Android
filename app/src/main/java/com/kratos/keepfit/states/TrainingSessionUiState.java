package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.TrainingSession;

public class TrainingSessionUiState {

    private final TrainingSession selectedTrainingSession;

    public TrainingSessionUiState(TrainingSession selectedTrainingSession) {
        this.selectedTrainingSession = selectedTrainingSession;
    }

    public TrainingSession getSelectedTrainingSession() {
        return selectedTrainingSession;
    }
}