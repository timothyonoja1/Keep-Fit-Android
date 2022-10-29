package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.entities.SkillLevel;
import com.kratos.keepfit.repositories.interfaces.SearchAndMatchRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeSearchAndMatchRepository implements SearchAndMatchRepository {

    private int age;
    private int height;
    private int weight;
    private final List<FitnessGoal> fitnessGoals = new ArrayList<>();
    private SkillLevel skillLevel;

    @Inject
    public FakeSearchAndMatchRepository() {

    }

    @Override
    public boolean saveSearchAndMatchDetails(
            int selectedAge, int selectedHeight, int selectedWeight,
            List<FitnessGoal> fitnessGoals, SkillLevel skillLevel) {
        age = selectedAge;
        height = selectedHeight;
        weight = selectedWeight;
        this.fitnessGoals.clear();
        this.fitnessGoals.addAll(fitnessGoals);
        this.skillLevel = skillLevel;
        return true;
    }

    @Override
    public boolean deleteAllPreviousSearchAndMatchDetails() {
        age = 0;
        height = 0;
        weight = 0;
        fitnessGoals.clear();
        skillLevel = null;

        return true;
    }

    @Override
    public int getAgeRangeID() {
        return 0;
    }

    @Override
    public int getHeightRangeID() {
        return 0;
    }

    @Override
    public int getWeightRangeID() {
        return 0;
    }

    @Override
    public List<Integer> getFitnessGoalIDs() {
        List<Integer> result = new ArrayList<>();
        for (FitnessGoal fitnessGoal : fitnessGoals) {
            result.add(fitnessGoal.getFitnessGoalID());
        }
        return result;
    }

    @Override
    public int getSkillLevelID() {
        return skillLevel.getSkillLevelID();
    }

}