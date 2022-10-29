package com.kratos.keepfit.viewmodels.real;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kratos.keepfit.entities.FitnessCategory;
import com.kratos.keepfit.entities.FitnessProgramme;
import com.kratos.keepfit.entities.FitnessVideo;
import com.kratos.keepfit.repositories.interfaces.FitnessCategoryRepository;
import com.kratos.keepfit.managers.interfaces.FitnessProgrammeManager;
import com.kratos.keepfit.repositories.interfaces.FitnessVideoRepository;
import com.kratos.keepfit.states.FitnessCategoryListUiState;
import com.kratos.keepfit.states.FitnessProgrammeListUiState;
import com.kratos.keepfit.states.FitnessVideoItemUiState;
import com.kratos.keepfit.states.FitnessVideoListUiState;
import com.kratos.keepfit.viewmodels.interfaces.FitnessProgrammesViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class FitnessProgrammeViewModelImpl extends ViewModel implements FitnessProgrammesViewModel {

    private final FitnessCategoryRepository fitnessCategoryRepository;
    private final FitnessProgrammeManager fitnessProgrammeManager;
    private final FitnessVideoRepository fitnessVideoRepository;
    private FitnessCategory selectedFitnessCategory;
    private FitnessProgramme selectedFitnessProgramme;
    private FitnessVideo selectedFitnessVideo;
    private final Executor executor;
    private final MutableLiveData<FitnessCategoryListUiState> fitnessCategoryUiState;
    private final MutableLiveData<FitnessProgrammeListUiState> fitnessProgrammeUiState;
    private final MutableLiveData<FitnessVideoListUiState> fitnessVideoListUiState;
    private final MutableLiveData<FitnessVideoItemUiState> fitnessVideoItemUiState;

    @Inject
    public FitnessProgrammeViewModelImpl(FitnessCategoryRepository fitnessCategoryRepository,
                                         FitnessProgrammeManager fitnessProgrammeManager,
                                         FitnessVideoRepository fitnessVideoRepository, Executor executor) {
        this.fitnessCategoryRepository = fitnessCategoryRepository;
        this.fitnessProgrammeManager = fitnessProgrammeManager;
        this.fitnessVideoRepository = fitnessVideoRepository;
        this.executor = executor;
        fitnessCategoryUiState = new MutableLiveData<>();
        fitnessProgrammeUiState = new MutableLiveData<>();
        fitnessVideoListUiState = new MutableLiveData<>();
        fitnessVideoItemUiState = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<FitnessCategoryListUiState> getFitnessCategoryListUiState() {
        fitnessCategoryUiState.setValue(
                new FitnessCategoryListUiState(true, new ArrayList<>(),
                        new ArrayList<>())
        );
        getAllFitnessCategories();
        return fitnessCategoryUiState;
    }

    @Override
    public MutableLiveData<FitnessProgrammeListUiState> getFitnessProgrammeListUiState() {
        fitnessProgrammeUiState.setValue(new FitnessProgrammeListUiState(
                true, new ArrayList<>(), selectedFitnessCategory));
        getFitnessProgrammes();
        return fitnessProgrammeUiState;
    }

    @Override
    public MutableLiveData<FitnessVideoListUiState> getFitnessVideoListUiState() {
        fitnessVideoListUiState.setValue(new FitnessVideoListUiState(
                true, new ArrayList<>(), selectedFitnessProgramme));
        getFitnessVideos();
        return fitnessVideoListUiState;
    }

    @Override
    public MutableLiveData<FitnessVideoItemUiState> getFitnessVideoItemUiState() {
        fitnessVideoItemUiState.setValue(new FitnessVideoItemUiState(selectedFitnessVideo));
        return fitnessVideoItemUiState;
    }

    @Override
    public void setFitnessCategory(FitnessCategory fitnessCategory) {
        selectedFitnessCategory = fitnessCategory;
    }

    @Override
    public void setSelectedFitnessCategory(FitnessCategory fitnessCategory) {
        selectedFitnessCategory = fitnessCategory;
    }

    @Override
    public void setSelectedFitnessProgramme(FitnessProgramme fitnessProgramme) {
        selectedFitnessProgramme = fitnessProgramme;
    }

    @Override
    public void setSelectedFitnessVideo(FitnessVideo fitnessVideo) {
        selectedFitnessVideo = fitnessVideo;
    }

    private void getAllFitnessCategories() {
        executor.execute(() -> {
            List<String> numberOfFitnessProgrammesList = new ArrayList<>();
            List<FitnessCategory> fitnessCategories = fitnessCategoryRepository.getAllFitnessCategoriesSync();
            for (FitnessCategory fitnessCategory : fitnessCategories) {
                int numberOfFitnessProgrammes = fitnessProgrammeManager
                        .getNumberOfFitnessProgrammesSync(fitnessCategory.getFitnessCategoryID());
                String numOfFitnessProgrammes = fitnessCategory.getName() + "\n (" + numberOfFitnessProgrammes + ")";
                numberOfFitnessProgrammesList.add(numOfFitnessProgrammes);
            }
            fitnessCategoryUiState.postValue(new FitnessCategoryListUiState(
                    false, fitnessCategories, numberOfFitnessProgrammesList));
        });
    }

    private void getFitnessProgrammes() {
        fitnessProgrammeManager.getFitnessProgrammes(
                selectedFitnessCategory.getFitnessCategoryID(),
                result -> fitnessProgrammeUiState.setValue(new FitnessProgrammeListUiState(
                        false, result, selectedFitnessCategory))
        );
    }

    private void getFitnessVideos() {
        fitnessVideoRepository.getFitnessVideos(
               selectedFitnessProgramme.getFitnessProgrammeID(),
                result -> fitnessVideoListUiState.setValue(new FitnessVideoListUiState(
                        false, result,
                        selectedFitnessProgramme))
        );
    }
}