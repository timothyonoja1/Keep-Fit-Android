package com.kratos.keepfit.repositories.interfaces;

import com.kratos.keepfit.entities.FitnessBuddy;
import java.util.List;

public interface FitnessBuddyRepository {

    List<FitnessBuddy> getFitnessBuddies(List<Integer> fitnessBuddyIDs);

}
