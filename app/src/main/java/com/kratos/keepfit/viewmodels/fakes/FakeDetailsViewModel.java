package com.kratos.keepfit.viewmodels.fakes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kratos.keepfit.entities.Allergy;
import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import com.kratos.keepfit.states.DetailsUiState;
import com.kratos.keepfit.states.DetailsUiStatus;
import com.kratos.keepfit.viewmodels.interfaces.DetailsViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class FakeDetailsViewModel extends ViewModel implements DetailsViewModel {

    private final MutableLiveData<DetailsUiState> detailsUiState = new MutableLiveData<>();
    private final List<FitnessGoal> selectedFitnessGoals = new ArrayList<>();
    private final List<WeeklyTrainingDuration> selectedWeeklyTrainingDurations = new ArrayList<>();
    private final List<Allergy> selectedAllergies = new ArrayList<>();

    @Inject
    public FakeDetailsViewModel() {

    }

    @Override
    public MutableLiveData<DetailsUiState> getDetailsUiState() {
        detailsUiState.setValue(new DetailsUiState(
                DetailsUiStatus.DetailsUiStateLoaded, "", getMockFitnessGoals(),
                getMockWeeklyTrainingDurations(), getMockAllergies(),
                false));
        return detailsUiState;
    }

    @Override
    public void onClick(FitnessGoal fitnessGoal) {
        for (FitnessGoal item : selectedFitnessGoals) {
            if (Objects.equals(item.getName(), fitnessGoal.getName())) {
                selectedFitnessGoals.remove(item);
                return;
            }
        }
        // If we get this far, fitness goal does not not exist in list
        selectedFitnessGoals.add(fitnessGoal);
    }

    @Override
    public void onClick(WeeklyTrainingDuration weeklyTrainingDuration) {
        for (WeeklyTrainingDuration item : selectedWeeklyTrainingDurations) {
            if (Objects.equals(item.getDescription(), weeklyTrainingDuration.getDescription())) {
                selectedWeeklyTrainingDurations.remove(item);
                return;
            }
        }
        // If we get this far, weekly training duration does not not exist in list
        selectedWeeklyTrainingDurations.add(weeklyTrainingDuration);
    }

    @Override
    public void onClick(Allergy allergy) {
        for (Allergy item : selectedAllergies) {
            if (Objects.equals(item.getName(), allergy.getName())){
                selectedAllergies.remove(item);
            }
        }
        // If we get this far, allergy does not not exist in list
        selectedAllergies.add(allergy);
    }

    @Override
    public void confirm() {
        if (selectedFitnessGoals.isEmpty() || selectedWeeklyTrainingDurations.isEmpty() || selectedAllergies.isEmpty()) {
            detailsUiState.setValue(new DetailsUiState(
                    DetailsUiStatus.InputError, "Please, ensure you choose some details", getMockFitnessGoals(),
                    getMockWeeklyTrainingDurations(), getMockAllergies(),
                    false));
        }
        else {
            detailsUiState.setValue(new DetailsUiState(
                    DetailsUiStatus.DetailsSubmissionSuccess, "", getMockFitnessGoals(),
                    getMockWeeklyTrainingDurations(), getMockAllergies(),
                    false));
        }
    }

    private List<FitnessGoal> getMockFitnessGoals(){
        List<FitnessGoal> fitnessGoals = new ArrayList<>();
        fitnessGoals.add(new FitnessGoal(1, "Muscular Endurance"));
        fitnessGoals.add(new FitnessGoal(2, "Muscular Strength"));
        fitnessGoals.add(new FitnessGoal(3, "Cardiovascular Endurance"));
        fitnessGoals.add(new FitnessGoal(4, "Flexibility"));
        fitnessGoals.add(new FitnessGoal(5, "Body Composition"));
        fitnessGoals.add(new FitnessGoal(6, "Fat Loss"));
        fitnessGoals.add(new FitnessGoal(6, "Improve Mental Health"));
        fitnessGoals.add(new FitnessGoal(7, "Tone Up"));
        fitnessGoals.add(new FitnessGoal(8, "Muscle Gain"));

        return fitnessGoals;
    }

    private List<WeeklyTrainingDuration> getMockWeeklyTrainingDurations(){
        List<WeeklyTrainingDuration> weeklyTrainingDurations = new ArrayList<>();
        weeklyTrainingDurations.add(new WeeklyTrainingDuration(
                1, 1, 2, "1-2 Days"
        ));
        weeklyTrainingDurations.add(new WeeklyTrainingDuration(
                2, 3, 4, "3-4 Days"
        ));
        weeklyTrainingDurations.add(new WeeklyTrainingDuration(
                3, 5, 7, "5+ Days"
        ));

        return weeklyTrainingDurations;
    }

    private List<Allergy> getMockAllergies() {
        List<Allergy> allergies = new ArrayList<>();
        allergies.add(new Allergy(1, "ShellFish"));
        allergies.add(new Allergy(2, "Gluten"));
        allergies.add(new Allergy(3, "Diary"));
        allergies.add(new Allergy(4, "Peanut"));
        allergies.add(new Allergy(5, "Tree Nut"));
        allergies.add(new Allergy(6, "Soy"));
        allergies.add(new Allergy(7, "Egg"));
        allergies.add(new Allergy(8, "Sesame"));
        allergies.add(new Allergy(9, "Mustard"));
        allergies.add(new Allergy(10, "Sulfite"));
        allergies.add(new Allergy(11, "Nightshade"));

        return allergies;
    }
}
