package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.FitnessVideo;

public class FitnessVideoItemUiState {

    private final FitnessVideo selectedFitnessVideo;

    public FitnessVideoItemUiState(FitnessVideo selectedFitnessVideo) {
        this.selectedFitnessVideo = selectedFitnessVideo;
    }

    public FitnessVideo getSelectedFitnessVideo() {
        return selectedFitnessVideo;
    }
}