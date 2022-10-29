package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.Allergy;
import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import java.util.List;

public class DetailsUiState {

    private final DetailsUiStatus detailsUiStatus;
    private final String errorMessage;
    private final List<FitnessGoal> fitnessGoals;
    private final List<WeeklyTrainingDuration> weeklyTrainingDurations;
    private final List<Allergy> allergies;
    private final boolean loogedInUser;

    public DetailsUiState(DetailsUiStatus detailsUiStatus, String errorMessage,
                          List<FitnessGoal> fitnessGoals,
                          List<WeeklyTrainingDuration> weeklyTrainingDurations,
                          List<Allergy> allergies, boolean loogedInUser) {
        this.detailsUiStatus = detailsUiStatus;
        this.errorMessage = errorMessage;
        this.fitnessGoals = fitnessGoals;
        this.weeklyTrainingDurations = weeklyTrainingDurations;
        this.allergies = allergies;
        this.loogedInUser = loogedInUser;
    }

    public DetailsUiStatus getDetailsUiStatus() {
        return detailsUiStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<FitnessGoal> getFitnessGoals() {
        return fitnessGoals;
    }

    public List<WeeklyTrainingDuration> getWeeklyTrainingDurations() {
        return weeklyTrainingDurations;
    }

    public List<Allergy> getAllergies() {
        return allergies;
    }

    public boolean isLoogedInUser() {
        return loogedInUser;
    }
}
