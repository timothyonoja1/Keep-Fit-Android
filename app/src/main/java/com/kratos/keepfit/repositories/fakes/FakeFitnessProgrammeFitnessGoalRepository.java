package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.repositories.interfaces.FitnessProgrammeFitnessGoalRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessProgrammeFitnessGoalRepository implements FitnessProgrammeFitnessGoalRepository {

    private List<Integer> fitnessProgrammeIDs;

    @Inject
    public FakeFitnessProgrammeFitnessGoalRepository() {
        fitnessProgrammeIDs = new ArrayList<>();
        fitnessProgrammeIDs.add(1);
        fitnessProgrammeIDs.add(2);
        fitnessProgrammeIDs.add(3);
        fitnessProgrammeIDs.add(4);
    }

    @Override
    public List<Integer> getFitnessProgrammeIDs(List<Integer> fitnessGoalIDs) {
        return fitnessProgrammeIDs;
    }
}
