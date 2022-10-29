package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.entities.SkillLevel;
import java.util.List;

public class SearchAndMatchUiState {

    private final boolean selectedAge;
    private final boolean selectedHeight;
    private final boolean selectedWeight;
    private final boolean selectedFitnessGoals;
    private final boolean selectedSkillLevels;
    private final boolean fetchingFitnessGoals;
    private final boolean fetchingSkillLevels;
    private final List<FitnessGoal> fitnessGoals;
    private final List<SkillLevel> skillLevels;

    public SearchAndMatchUiState(
            boolean selectedAge, boolean selectedHeight, boolean selectedWeight,
            boolean selectedFitnessGoals, boolean selectedSkillLevels,
            boolean fetchingFitnessGoals, boolean fetchingSkillLevels,
            List<FitnessGoal> fitnessGoals, List<SkillLevel> skillLevels) {
        this.selectedAge = selectedAge;
        this.selectedHeight = selectedHeight;
        this.selectedWeight = selectedWeight;
        this.selectedFitnessGoals = selectedFitnessGoals;
        this.selectedSkillLevels = selectedSkillLevels;
        this.fetchingFitnessGoals = fetchingFitnessGoals;
        this.fetchingSkillLevels = fetchingSkillLevels;
        this.fitnessGoals = fitnessGoals;
        this.skillLevels = skillLevels;
    }

    public boolean hasSelectedAge() {
        return selectedAge;
    }

    public boolean hasSelectedHeight() {
        return selectedHeight;
    }

    public boolean hasSelectedWeight() {
        return selectedWeight;
    }

    public boolean hasSelectedFitnessGoals() {
        return selectedFitnessGoals;
    }

    public boolean hasSelectedSkillLevels() {
        return selectedSkillLevels;
    }

    public boolean isFetchingFitnessGoals() {
        return fetchingFitnessGoals;
    }

    public boolean isFetchingSkillLevels() {
        return fetchingSkillLevels;
    }

    public List<FitnessGoal> getFitnessGoals() {
        return fitnessGoals;
    }

    public List<SkillLevel> getSkillLevels() {
        return skillLevels;
    }
}
