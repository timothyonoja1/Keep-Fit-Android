package com.kratos.keepfit.repositories.interfaces;

import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.entities.SkillLevel;

import java.util.List;

public interface SearchAndMatchRepository {

    boolean saveSearchAndMatchDetails(
            int selectedAge, int selectedHeight,
            int selectedWeight, List<FitnessGoal> fitnessGoal,
            SkillLevel skillLevel);

    boolean deleteAllPreviousSearchAndMatchDetails();

    int getAgeRangeID();

    int getHeightRangeID();

    int getWeightRangeID();
    
    List<Integer> getFitnessGoalIDs();

    int getSkillLevelID();
    
}
