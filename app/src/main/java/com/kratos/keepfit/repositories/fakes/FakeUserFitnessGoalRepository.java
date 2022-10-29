package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.repositories.interfaces.UserFitnessGoalRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeUserFitnessGoalRepository implements UserFitnessGoalRepository {

    private final List<Integer> fitnessGoalIDs = new ArrayList<>();

    @Inject
    public FakeUserFitnessGoalRepository(){

    }

    @Override
    public boolean saveUserFitnessGoalID(List<Integer> fitnessGoalIDs) {
        this.fitnessGoalIDs.clear();
        this.fitnessGoalIDs.addAll(fitnessGoalIDs);
        return true;
    }

    @Override
    public List<Integer> getSavedFitnessGoalIDsOfLoggedInUser() {
        return fitnessGoalIDs;
    }

    @Override
    public boolean sendSavedUserFitnessGoalsToBackend() {
        return true;
    }
}
