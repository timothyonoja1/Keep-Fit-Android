package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.LiveFitness;
import java.util.List;

public class LiveFitnessListUiState {

    private final boolean fetchingLiveFitnessList;
    private final List<LiveFitness> liveFitnessList;

    public LiveFitnessListUiState(boolean fetchingLiveFitnessList, List<LiveFitness> liveFitnessList) {
        this.fetchingLiveFitnessList = fetchingLiveFitnessList;
        this.liveFitnessList = liveFitnessList;
    }

    public boolean isFetchingLiveFitnessList() {
        return fetchingLiveFitnessList;
    }

    public List<LiveFitness> getLiveFitnessList() {
        return liveFitnessList;
    }
}