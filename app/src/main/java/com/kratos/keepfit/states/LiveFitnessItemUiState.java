package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.LiveFitness;

public class LiveFitnessItemUiState {

    private final LiveFitness selectedLiveFitness;

    public LiveFitnessItemUiState(LiveFitness selectedLiveFitness) {
        this.selectedLiveFitness = selectedLiveFitness;
    }

    public LiveFitness getSelectedLiveFitness() {
        return selectedLiveFitness;
    }
}