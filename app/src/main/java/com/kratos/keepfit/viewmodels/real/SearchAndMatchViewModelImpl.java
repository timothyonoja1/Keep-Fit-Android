package com.kratos.keepfit.viewmodels.real;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.entities.SkillLevel;
import com.kratos.keepfit.managers.interfaces.FitnessGoalManager;
import com.kratos.keepfit.repositories.interfaces.AgeRangeRepository;
import com.kratos.keepfit.repositories.interfaces.HeightRangeRepository;
import com.kratos.keepfit.repositories.interfaces.SearchAndMatchRepository;
import com.kratos.keepfit.repositories.interfaces.SkillLevelRepository;
import com.kratos.keepfit.repositories.interfaces.WeightRangeRepository;
import com.kratos.keepfit.states.SearchAndMatchUiState;
import com.kratos.keepfit.viewmodels.interfaces.SearchAndMatchViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SearchAndMatchViewModelImpl extends ViewModel implements SearchAndMatchViewModel {

    private final SearchAndMatchRepository searchAndMatchRepository;
    private final FitnessGoalManager fitnessGoalManager;
    private final SkillLevelRepository skillLevelRepository;
    private final AgeRangeRepository ageRangeRepository;
    private final HeightRangeRepository heightRangeRepository;
    private final WeightRangeRepository weightRangeRepository;
    private final Executor executor;
    private final MutableLiveData<SearchAndMatchUiState> searchAndMatchUiState;
    private final List<FitnessGoal> selectedFitnessGoals = new ArrayList<>();
    private SkillLevel selectedSkillLevel;
    private int selectedAge;
    private int selectedHeight;
    private int selectedWeight;

    @Inject
    public SearchAndMatchViewModelImpl(
            SearchAndMatchRepository searchAndMatchRepository,
            FitnessGoalManager fitnessGoalManager,
            SkillLevelRepository skillLevelRepository,
            AgeRangeRepository ageRangeRepository,
            HeightRangeRepository heightRangeRepository,
            WeightRangeRepository weightRangeRepository,
            Executor executor) {
        this.searchAndMatchRepository = searchAndMatchRepository;
        this.fitnessGoalManager = fitnessGoalManager;
        this.skillLevelRepository = skillLevelRepository;
        this.ageRangeRepository = ageRangeRepository;
        this.heightRangeRepository = heightRangeRepository;
        this.weightRangeRepository = weightRangeRepository;
        this.executor = executor;
        searchAndMatchUiState = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<SearchAndMatchUiState> getSearchAndMatchUiState() {
        searchAndMatchUiState.setValue(new SearchAndMatchUiState(
                true, true, true, true, true,
                true, true, new ArrayList<>(), new ArrayList<>()
        ));
        executor.execute(() -> {
            List<FitnessGoal> fitnessGoals = fitnessGoalManager.getALlFitnessGoals();
            List<SkillLevel> skillLevels = skillLevelRepository.getAllSkillLevels();
            searchAndMatchUiState.postValue(new SearchAndMatchUiState(
                    false, false, false, false, false,
                    false, false, fitnessGoals, skillLevels
            ));
        });
        return searchAndMatchUiState;
    }

    @Override
    public void saveAge(int age) {
        selectedAge = age;
    }

    @Override
    public void saveHeight(int height) {
        selectedHeight = height;
    }

    @Override
    public void saveWeight(int weight) {
        selectedWeight = weight;
    }

    @Override
    public void onClickFitnessGoal(FitnessGoal fitnessGoal) {
        for (FitnessGoal item : selectedFitnessGoals) {
            if (Objects.equals(item.getName(), fitnessGoal.getName())) {
                return;
            }
        }
        // If we get this far, fitness goal does not not exist in list
        selectedFitnessGoals.add(fitnessGoal);
    }

    @Override
    public void onClickSkillLevel(SkillLevel skillLevel) {
        selectedSkillLevel = skillLevel;
    }

    @Override
    public void confirm() {
        executor.execute(() -> {
            ageRangeRepository.saveAgeSelectedByUser(selectedAge);
            heightRangeRepository.saveHeightSelectedByUser(selectedHeight);
            weightRangeRepository.saveWeightSelectedByUser(selectedWeight);
            fitnessGoalManager.saveUserFitnessGoals(selectedFitnessGoals);
            skillLevelRepository.saveSkillLevelSelectedByUser(selectedSkillLevel);
        });
    }

}