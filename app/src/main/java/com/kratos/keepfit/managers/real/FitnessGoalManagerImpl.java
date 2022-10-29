package com.kratos.keepfit.managers.real;

import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.managers.interfaces.FitnessGoalManager;
import com.kratos.keepfit.repositories.interfaces.FitnessGoalRepository;
import com.kratos.keepfit.repositories.interfaces.UserFitnessGoalRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FitnessGoalManagerImpl implements FitnessGoalManager {

    private final FitnessGoalRepository fitnessGoalRepository;
    private final UserFitnessGoalRepository userFitnessGoalRepository;

    @Inject
    public FitnessGoalManagerImpl(FitnessGoalRepository fitnessGoalRepository,
                                  UserFitnessGoalRepository userFitnessGoalRepository) {
        this.fitnessGoalRepository = fitnessGoalRepository;
        this.userFitnessGoalRepository = userFitnessGoalRepository;
    }

    @Override
    public List<FitnessGoal> getALlFitnessGoals() {
        return fitnessGoalRepository.getAllFitnessGoals();
    }

    @Override
    public List<Integer> getSavedFitnessGoalIDsOfLoggedInUser() {
        return userFitnessGoalRepository.getSavedFitnessGoalIDsOfLoggedInUser();
    }

    @Override
    public boolean saveUserFitnessGoals(List<FitnessGoal> fitnessGoals) {
        List<Integer> fitnessGoalIDs = new ArrayList<>();
        for (FitnessGoal fitnessGoal : fitnessGoals) {
            fitnessGoalIDs.add(fitnessGoal.getFitnessGoalID());
        }
        return userFitnessGoalRepository.saveUserFitnessGoalID(fitnessGoalIDs);
    }
}