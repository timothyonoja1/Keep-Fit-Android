package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.entities.SkillLevel;
import com.kratos.keepfit.managers.interfaces.FitnessGoalManager;
import com.kratos.keepfit.repositories.interfaces.AgeRangeRepository;
import com.kratos.keepfit.repositories.interfaces.HeightRangeRepository;
import com.kratos.keepfit.repositories.interfaces.SearchAndMatchRepository;
import com.kratos.keepfit.repositories.interfaces.SkillLevelRepository;
import com.kratos.keepfit.repositories.interfaces.WeightRangeRepository;
import java.util.List;
import javax.inject.Inject;

public class SearchAndMatchRepositoryImpl implements SearchAndMatchRepository {

    private final AgeRangeRepository ageRangeRepository;
    private final HeightRangeRepository heightRangeRepository;
    private final WeightRangeRepository weightRangeRepository;
    private final FitnessGoalManager fitnessGoalManager;
    private final SkillLevelRepository skillLevelRepository;

    @Inject
    public SearchAndMatchRepositoryImpl(
            AgeRangeRepository ageRangeRepository,
            HeightRangeRepository heightRangeRepository,
            WeightRangeRepository weightRangeRepository,
            FitnessGoalManager fitnessGoalManager,
            SkillLevelRepository skillLevelRepository) {
        this.ageRangeRepository = ageRangeRepository;
        this.heightRangeRepository = heightRangeRepository;
        this.weightRangeRepository = weightRangeRepository;
        this.fitnessGoalManager = fitnessGoalManager;
        this.skillLevelRepository = skillLevelRepository;
    }

    @Override
    public boolean saveSearchAndMatchDetails(
            int selectedAge, int selectedHeight, int selectedWeight,
            List<FitnessGoal> fitnessGoals, SkillLevel skillLevel) {
        ageRangeRepository.saveAgeSelectedByUser(selectedAge);
        heightRangeRepository.saveHeightSelectedByUser(selectedHeight);
        weightRangeRepository.saveWeightSelectedByUser(selectedWeight);
        fitnessGoalManager.saveUserFitnessGoals(fitnessGoals);
        skillLevelRepository.saveSkillLevelSelectedByUser(skillLevel);
        return true;
    }

    @Override
    public boolean deleteAllPreviousSearchAndMatchDetails() {
        ageRangeRepository.deleteAgeSelectedByUser();
        heightRangeRepository.deleteHeightSelectedByUser();
        weightRangeRepository.deleteWeightSelectedByUser();
        skillLevelRepository.deleteSkillLevelSelectedByUser();
        return true;
    }

    @Override
    public int getAgeRangeID() {
        return ageRangeRepository.getAgeRangeIDSelectedByUser();
    }

    @Override
    public int getHeightRangeID() {
        return heightRangeRepository.getHeightRangeIDSelectedBUser();
    }

    @Override
    public int getWeightRangeID() {
        return weightRangeRepository.getWeightRangeIDSelectedBUser();
    }


    @Override
    public List<Integer> getFitnessGoalIDs() {
        return fitnessGoalManager.getSavedFitnessGoalIDsOfLoggedInUser();
    }

    @Override
    public int getSkillLevelID() {
        return skillLevelRepository.getSkillLevelIDSelectedByUser();
    }

}
