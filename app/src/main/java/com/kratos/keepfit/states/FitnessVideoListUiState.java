package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.FitnessProgramme;
import com.kratos.keepfit.entities.FitnessVideo;
import java.util.List;

public class FitnessVideoListUiState {

    private final boolean fetchingVideoList;
    private final List<FitnessVideo> fitnessVideoList;
    private final FitnessProgramme selectedFitnessProgramme;

    public FitnessVideoListUiState(boolean fetchingVideoList,
                                   List<FitnessVideo> fitnessVideoList,
                                   FitnessProgramme selectedFitnessProgramme) {
        this.fetchingVideoList = fetchingVideoList;
        this.fitnessVideoList = fitnessVideoList;
        this.selectedFitnessProgramme = selectedFitnessProgramme;
    }

    public boolean isFetchingVideoList() {
        return fetchingVideoList;
    }

    public List<FitnessVideo> getFitnessVideoList() {
        return fitnessVideoList;
    }

    public FitnessProgramme getSelectedFitnessProgramme() {
        return selectedFitnessProgramme;
    }
}