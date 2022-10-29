package com.kratos.keepfit.viewmodels.interfaces;

import androidx.lifecycle.MutableLiveData;
import com.kratos.keepfit.entities.Allergy;
import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import com.kratos.keepfit.states.DetailsUiState;

public interface DetailsViewModel {

    MutableLiveData<DetailsUiState> getDetailsUiState();

    void onClick(FitnessGoal fitnessGoal);

    void onClick(WeeklyTrainingDuration weeklyTrainingDuration);

    void onClick(Allergy allergy);

    void confirm();

}
