package com.kratos.keepfit.viewmodels.interfaces;

import androidx.lifecycle.MutableLiveData;

import com.kratos.keepfit.entities.Allergy;
import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.entities.SkillLevel;
import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import com.kratos.keepfit.states.SearchAndMatchUiState;

public interface SearchAndMatchViewModel {

    MutableLiveData<SearchAndMatchUiState> getSearchAndMatchUiState();

    void saveAge(int age);

    void saveHeight(int height);

    void saveWeight(int weight);

    void onClickFitnessGoal(FitnessGoal fitnessGoal);

    void onClickSkillLevel(SkillLevel skillLevel);

    void confirm();

}
