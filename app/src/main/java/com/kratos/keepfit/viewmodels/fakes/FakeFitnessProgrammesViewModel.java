package com.kratos.keepfit.viewmodels.fakes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kratos.keepfit.entities.FitnessCategory;
import com.kratos.keepfit.entities.FitnessProgramme;
import com.kratos.keepfit.entities.FitnessVideo;
import com.kratos.keepfit.states.FitnessCategoryListUiState;
import com.kratos.keepfit.states.FitnessProgrammeListUiState;
import com.kratos.keepfit.states.FitnessVideoListUiState;
import com.kratos.keepfit.states.FitnessVideoItemUiState;
import com.kratos.keepfit.viewmodels.interfaces.FitnessProgrammesViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

/** Fake MainViewModel implementation class. */
@HiltViewModel
public class FakeFitnessProgrammesViewModel extends ViewModel implements FitnessProgrammesViewModel {

    private FitnessCategory selectedFitnessCategory;
    private FitnessProgramme selectedFitnessProgramme;
    private FitnessVideo selectedFitnessVideo;
    private List<FitnessVideo> mockFitnessVideoList;

    /** Constructs a new instance. */
    @Inject
    public FakeFitnessProgrammesViewModel(){
        mockFitnessVideoList = getMockFitnessVideoList();
    }

    @Override
    public MutableLiveData<FitnessCategoryListUiState> getFitnessCategoryListUiState() {
        List<FitnessCategory> fitnessCategories = new ArrayList<>();
        fitnessCategories.add(new FitnessCategory(1, "Circuit Training"));
        MutableLiveData<FitnessCategoryListUiState> fitnessCategoryUiState = new MutableLiveData<>();
        List<String> numberOfFitnessProgrammes = new ArrayList<>();
        for (FitnessCategory fitnessCategory : fitnessCategories) {
            numberOfFitnessProgrammes.add(fitnessCategory.getName());
        }

        fitnessCategoryUiState.setValue(new FitnessCategoryListUiState(
                false, fitnessCategories, numberOfFitnessProgrammes));

        return fitnessCategoryUiState;
    }

    @Override
    public MutableLiveData<FitnessProgrammeListUiState> getFitnessProgrammeListUiState() {
        MutableLiveData<FitnessProgrammeListUiState> fitnessClassListUiState = new MutableLiveData<>();

        List<FitnessProgramme> fitnessProgrammeList = getMockFitnessProgrammeList();

        fitnessClassListUiState.setValue(new FitnessProgrammeListUiState(
                false, fitnessProgrammeList, selectedFitnessCategory));
        return fitnessClassListUiState;
    }

    @Override
    public MutableLiveData<FitnessVideoListUiState> getFitnessVideoListUiState() {
        MutableLiveData<FitnessVideoListUiState> fitnessVideoListUiState = new MutableLiveData<>();

        List<FitnessVideo> fitnessVideoList = getMockFitnessVideoList();

        List<FitnessVideo> result = new ArrayList<>();

        for (FitnessVideo fitnessVideo : fitnessVideoList){
            if (fitnessVideo.getFitnessProgrammeID() == selectedFitnessProgramme.getFitnessProgrammeID()){
                result.add(fitnessVideo);
            }
        }

        fitnessVideoListUiState.setValue(new FitnessVideoListUiState(
                false, result, selectedFitnessProgramme));

        return fitnessVideoListUiState;
    }

    @Override
    public MutableLiveData<FitnessVideoItemUiState> getFitnessVideoItemUiState() {
        MutableLiveData<FitnessVideoItemUiState> fitnessVideoItemUiState = new MutableLiveData<>();
        fitnessVideoItemUiState.setValue(
                new FitnessVideoItemUiState(selectedFitnessVideo)
        );
        return fitnessVideoItemUiState;
    }

    @Override
    public void setFitnessCategory(FitnessCategory fitnessCategory) {

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

    private List<FitnessProgramme> getMockFitnessProgrammeList() {
        List<FitnessProgramme> fitnessProgrammeList = new ArrayList<>();

        fitnessProgrammeList.add(new FitnessProgramme(1, "Circuit Training Fundamentals",
                "Completed by Dwayne Johnson", "23 July, at 10:00 AM",
                "12", "4", "Requires a mat & exercise band",
                "@drawable/circuit_training", 1));

        fitnessProgrammeList.add(new FitnessProgramme(2, "Cardio Hybrid",
                "Completed by Chris Bab", "15 August, at 12:00 PM",
                "12", "4", "Requires a mat & skipping rope",
                "@drawable/cardio_hybrid", 1));


        fitnessProgrammeList.add(new FitnessProgramme(3, "Muscular Circuit",
                "Completed by Tania Hardy", "19 August, at 12:00 PM",
                "12", "4", "Requires a mat or clean floor",
                "@drawable/muscular_circuit", 1));

        fitnessProgrammeList.add(new FitnessProgramme(4, "Strength training",
                "Completed by Chris Bab", "15 September, at 12:00 PM",
                "12", "4", "Requires a mat or exercise band",
                "@drawable/strength_training", 1));

        return fitnessProgrammeList;
    }

    private List<FitnessVideo> getMockFitnessVideoList() {
        List<FitnessVideo> fitnessVideoList = new ArrayList<>();
        fitnessVideoList.add(new FitnessVideo(
                1, 1, "@drawable/banded_lateral_walk",
                "", "Banded Lateral Walk", "0.30 seconds Body. Building",
                false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                2, 1, "@drawable/bicycle_crunch",
                "", "Bicycle Crunch", "0.30 seconds. Body Building",
                true, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                3, 1, "@drawable/donkey_kicks",
                "", "Donkey Kicks", "0.48 mi away. Body Building",
                false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                4, 1, "@drawable/in_and_out_jump",
                "", "In and Out", "0.31 mi away. Body Building",
                false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                5, 1, "@drawable/kneeling_push_ups",
                "", "Kneeling push up", "1.23 mi away. Body Building",
                true, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                6, 1, "@drawable/lunges",
                "", "Lunges", "0.48 mi away. Body Building", false,
                5, 30));

        fitnessVideoList.add(new FitnessVideo(
                7, 2, "@drawable/burpees",
                "", "Burpees", "0.30 seconds. Body Building", false,
                5, 30));

        fitnessVideoList.add(new FitnessVideo(
                8, 2, "@drawable/feet_together_skip",
                "", "Fit together Skip", "0.30 seconds. Body Building",
                true, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                9, 3, "@drawable/body_weight_squats",
                "", "Body Weight Squats", "0.30 seconds. Body Building",
                false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                10, 3, "@drawable/elbow_plank",
                "", "Elbow Plank", "0.30 seconds. Body Building",
                true, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                11, 3, "@drawable/foot_plank_bench",
                "", "1 Foot Plank + Bench/Chair", "0.40 mi away. Body Building",
                false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                12, 3, "@drawable/foot_plank",
                "", "Elbow Plank", "0.31 mi away. Body Building", false,
                5, 30));

        fitnessVideoList.add(new FitnessVideo(
                13, 3, "@drawable/push_ups",
                "", "Push ups", "0.23 mi away. Body Building", true,
                5, 30));

        fitnessVideoList.add(new FitnessVideo(
                14, 4, "@drawable/chest_press",
                "", "Chest Press, Inc Weights", "0.30 seconds. Body Building",
                false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                15, 4, "@drawable/chest_press",
                "", "Chest Press, Inc Weights", "0.30 seconds. Body Building",
                true, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                16, 4, "@drawable/barbell_squats",
                "", "Barbell Squats", "0.48 mi away. Body Building",
                false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                16, 4, "@drawable/sumo_deadlifts",
                "", "Sumo Deadlifts", "0.31 mi away. Body Building",
                false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                16, 4, "@drawable/swiss_ball",
                "", "Swiss Ball Barbell Chest Press", "123 mi away. Body Building",
                false, 5, 30));

        return fitnessVideoList;
    }
}