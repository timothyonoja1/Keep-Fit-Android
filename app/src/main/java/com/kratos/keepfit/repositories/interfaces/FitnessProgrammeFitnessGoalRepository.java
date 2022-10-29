package com.kratos.keepfit.repositories.interfaces;

import java.util.List;

public interface FitnessProgrammeFitnessGoalRepository {

    List<Integer> getFitnessProgrammeIDs(List<Integer> fitnessGoalIDs);

}
