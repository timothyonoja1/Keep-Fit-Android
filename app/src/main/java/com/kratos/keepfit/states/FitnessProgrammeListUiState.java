package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.FitnessCategory;
import com.kratos.keepfit.entities.FitnessProgramme;
import java.util.List;

public class FitnessProgrammeListUiState {

    private final boolean fetchingFitnessProgrammeLists;
    private final List<FitnessProgramme> fitnessProgrammeList;
    private final FitnessCategory selectedFitnessCategory;

    public FitnessProgrammeListUiState(boolean fetchingFitnessProgrammeLists,
                                       List<FitnessProgramme> fitnessProgrammeList, FitnessCategory fitnessCategory) {
        this.fetchingFitnessProgrammeLists = fetchingFitnessProgrammeLists;
        this.fitnessProgrammeList = fitnessProgrammeList;
        selectedFitnessCategory = fitnessCategory;
    }

    public boolean isFetchingFitnessProgrammeLists() {
        return fetchingFitnessProgrammeLists;
    }

    public List<FitnessProgramme> getFitnessProgrammeList() {
        return fitnessProgrammeList;
    }

    public FitnessCategory getSelectedFitnessCategory() {
        return selectedFitnessCategory;
    }
}