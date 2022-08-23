package com.kratos.keepfit.viewmodels.fakes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kratos.keepfit.entities.Training;
import com.kratos.keepfit.entities.TrainingSession;
import com.kratos.keepfit.states.TrainingListUiState;
import com.kratos.keepfit.states.TrainingSessionListUiState;
import com.kratos.keepfit.states.TrainingSessionUiState;
import com.kratos.keepfit.viewmodels.interfaces.TrainingViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

/** Fake MainViewModel implementation class. */
@HiltViewModel
public class FakeTrainingViewModel extends ViewModel implements TrainingViewModel {

    private Training selectedTraining;
    private TrainingSession selectedTrainingSession;
    private List<TrainingSession> mockTrainingSessionList;

    /** Constructs a new instance. */
    @Inject
    public FakeTrainingViewModel(){
        mockTrainingSessionList = getMockTrainingSessionList();
    }

    @Override
    public MutableLiveData<TrainingListUiState> getTrainingListUiState() {
        MutableLiveData<TrainingListUiState> trainingListUiState = new MutableLiveData<>();

        List<Training> trainingList = getMockTrainingList();

        trainingListUiState.setValue(new TrainingListUiState(false, trainingList));
        return trainingListUiState;
    }

    @Override
    public MutableLiveData<TrainingSessionListUiState> getTrainingSessionListUiState() {
        MutableLiveData<TrainingSessionListUiState> trainingSessionListUiState = new MutableLiveData<>();

        List<TrainingSession> trainingSessionList = getMockTrainingSessionList();

        List<TrainingSession> result = new ArrayList<>();

        for (TrainingSession trainingSession : trainingSessionList){
            if (trainingSession.getTrainingID() == selectedTraining.getTrainingID()){
                result.add(trainingSession);
            }
        }

        trainingSessionListUiState.setValue(new TrainingSessionListUiState(
                false, selectedTraining, result));

        return trainingSessionListUiState;
    }

    @Override
    public MutableLiveData<TrainingSessionUiState> getTrainingSessionUiState() {
        MutableLiveData<TrainingSessionUiState> trainingSessionUiState = new MutableLiveData<>();
        trainingSessionUiState.setValue(
                new TrainingSessionUiState(selectedTrainingSession)
        );
        return trainingSessionUiState;
    }

    @Override
    public void setSelectedTraining(Training training) {
        this.selectedTraining = training;
    }

    @Override
    public void setSelectedTrainingSession(TrainingSession trainingSession) {
        this.selectedTrainingSession = trainingSession;
    }

    private List<Training> getMockTrainingList() {
        List<Training> trainingList = new ArrayList<>();

        trainingList.add(new Training(1, "Circuit Training Fundamentals",
                "Completed by Dwayne Johnson", "23 July, at 10:00 AM",
                "12", "4", "Requires a mat & exercise band",
                "@drawable/circuit_training"));

        trainingList.add(new Training(2, "Cardio Hybrid",
                "Completed by Chris Bab", "15 August, at 12:00 PM",
                "12", "4", "Requires a mat & skipping rope",
                "@drawable/cardio_hybrid"));

        trainingList.add(new Training(3, "Muscular Circuit",
                "Completed by Tania Hardy", "19 August, at 12:00 PM",
                "12", "4", "Requires a mat or clean floor",
                "@drawable/muscular_circuit"));

        trainingList.add(new Training(4, "Strangth training",
                "Completed by Chris Bab", "15 September, at 12:00 PM",
                "12", "4", "Requires a mat or exercise band",
                "@drawable/strength_training"));

        return trainingList;
    }

    private List<TrainingSession> getMockTrainingSessionList() {
        List<TrainingSession> trainingSessionList = new ArrayList<>();
        trainingSessionList.add(new TrainingSession(
                1, 1, "@drawable/banded_lateral_walk",
                "Banded Lateral Walk", "0.30 seconds Body. Building", false));

        trainingSessionList.add(new TrainingSession(
                2, 1, "@drawable/bicycle_crunch",
                "Bicycle Crunch", "0.30 seconds. Body Building", true));

        trainingSessionList.add(new TrainingSession(
                3, 1, "@drawable/donkey_kicks",
                "Donkey Kicks", "0.48 mi away. Body Building", false));

        trainingSessionList.add(new TrainingSession(
                4, 1, "@drawable/in_and_out_jump",
                "Donkey Kicks", "0.31 mi away. Body Building", false));

        trainingSessionList.add(new TrainingSession(
                5, 1, "@drawable/kneeling_push_ups",
                "Donkey Kicks", "1.23 mi away. Body Building", true));

        trainingSessionList.add(new TrainingSession(
                6, 1, "@drawable/lunges",
                "Donkey Kicks", "0.48 mi away. Body Building", false));

        trainingSessionList.add(new TrainingSession(
                7, 2, "@drawable/burpees",
                "Burpees", "0.30 seconds. Body Building", false));

        trainingSessionList.add(new TrainingSession(
                8, 2, "@drawable/feet_together_skip",
                "Fit together Skip", "0.30 seconds. Body Building", true));

        trainingSessionList.add(new TrainingSession(
                9, 3, "@drawable/body_weight_squats",
                "Body Weight Squats", "0.30 seconds. Body Building", false));

        trainingSessionList.add(new TrainingSession(
                10, 3, "@drawable/elbow_plank",
                "Elbow Plank", "0.30 seconds. Body Building", true));

        trainingSessionList.add(new TrainingSession(
                11, 3, "@drawable/foot_plank_bench",
                "1 Foot Plank + Bench/Chair", "0.40 mi away. Body Building", false));

        trainingSessionList.add(new TrainingSession(
                12, 3, "@drawable/foot_plank",
                "Elbow Plank", "0.31 mi away. Body Building", false));

        trainingSessionList.add(new TrainingSession(
                13, 3, "@drawable/push_ups",
                "Push ups", "0.23 mi away. Body Building", true));

        trainingSessionList.add(new TrainingSession(
                14, 4, "@drawable/chest_press",
                "Chest Press, Inc Weights", "0.30 seconds. Body Building", false));

        trainingSessionList.add(new TrainingSession(
                15, 4, "@drawable/chest_press",
                "Chest Press, Inc Weights", "0.30 seconds. Body Building", true));

        trainingSessionList.add(new TrainingSession(
                16, 4, "@drawable/barbell_squats",
                "Barbell Squats", "0.48 mi away. Body Building", false));

        trainingSessionList.add(new TrainingSession(
                16, 4, "@drawable/sumo_deadlifts",
                "Sumo Deadlifts", "0.31 mi away. Body Building", false));

        trainingSessionList.add(new TrainingSession(
                16, 4, "@drawable/swiss_ball",
                "Swiss Ball Barbell Chest Press", "123 mi away. Body Building", false));

        return trainingSessionList;
    }
}