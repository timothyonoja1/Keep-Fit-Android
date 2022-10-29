package com.kratos.keepfit.viewmodels.interfaces;

import androidx.lifecycle.MutableLiveData;
import com.kratos.keepfit.entities.FitnessCategory;
import com.kratos.keepfit.entities.FitnessProgramme;
import com.kratos.keepfit.entities.FitnessVideo;
import com.kratos.keepfit.states.FitnessCategoryListUiState;
import com.kratos.keepfit.states.FitnessProgrammeListUiState;
import com.kratos.keepfit.states.FitnessVideoListUiState;
import com.kratos.keepfit.states.FitnessVideoItemUiState;

public interface FitnessProgrammesViewModel {

    MutableLiveData<FitnessCategoryListUiState> getFitnessCategoryListUiState();

    MutableLiveData<FitnessProgrammeListUiState> getFitnessProgrammeListUiState();

    MutableLiveData<FitnessVideoListUiState> getFitnessVideoListUiState();

    MutableLiveData<FitnessVideoItemUiState> getFitnessVideoItemUiState();

    void setFitnessCategory(FitnessCategory fitnessCategory);

    void setSelectedFitnessCategory(FitnessCategory fitnessCategory);

    void setSelectedFitnessProgramme(FitnessProgramme fitnessProgramme);

    void setSelectedFitnessVideo(FitnessVideo fitnessVideo);

}