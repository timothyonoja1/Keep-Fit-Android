package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.FitnessCategory;
import java.util.List;

public class FitnessCategoryListUiState {

    private final boolean fetchingFitnessCategoryLists;
    private final List<FitnessCategory> fitnessCategoryList;
    private final List<String> numberOfFitnessProgrammes;

    public FitnessCategoryListUiState(boolean fetchingFitnessCategoryLists,
                                      List<FitnessCategory> fitnessCategoryList, List<String>  numberOfFitnessProgrammes) {
        this.fetchingFitnessCategoryLists = fetchingFitnessCategoryLists;
        this.fitnessCategoryList = fitnessCategoryList;
        this.numberOfFitnessProgrammes = numberOfFitnessProgrammes;
    }

    public boolean isFetchingFitnessCategoryLists() {
        return fetchingFitnessCategoryLists;
    }

    public List<FitnessCategory> getFitnessCategoryList() {
        return fitnessCategoryList;
    }

    public List<String>  getNumberOfFitnessProgrammes() {
        return numberOfFitnessProgrammes;
    }
}