package com.kratos.keepfit.viewmodels.fakes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kratos.keepfit.entities.Allergy;
import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.entities.SkillLevel;
import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import com.kratos.keepfit.states.SearchAndMatchUiState;
import com.kratos.keepfit.viewmodels.interfaces.SearchAndMatchViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class FakeSearchAndMatchViewModel extends ViewModel implements SearchAndMatchViewModel {

    private final MutableLiveData<SearchAndMatchUiState> searchAndMatchUiState = new MutableLiveData<>();

    @Inject
    public FakeSearchAndMatchViewModel() {

    }

    @Override
    public MutableLiveData<SearchAndMatchUiState> getSearchAndMatchUiState() {
        searchAndMatchUiState.setValue(new SearchAndMatchUiState(
                false, false, false, false, false,
                false, false, getMockFitnessGoals(), getMockSkillLevels()
        ));
        return searchAndMatchUiState;
    }

    @Override
    public void saveAge(int age) {

    }

    @Override
    public void saveHeight(int height) {

    }

    @Override
    public void saveWeight(int weight) {

    }

    @Override
    public void onClickFitnessGoal(FitnessGoal fitnessGoal) {

    }

    @Override
    public void onClickSkillLevel(SkillLevel skillLevel) {

    }

    @Override
    public void confirm() {

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

    private List<SkillLevel> getMockSkillLevels() {
        List<SkillLevel> skillLevels = new ArrayList<>();
        skillLevels.add(new SkillLevel(1, "Beginner"));
        skillLevels.add(new SkillLevel(2, "Advanced Beginner"));
        skillLevels.add(new SkillLevel(3, "Competent"));
        skillLevels.add(new SkillLevel(4, "Expert"));

        return skillLevels;
    }
}
