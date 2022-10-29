package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.FitnessBuddy;
import java.util.List;

public interface FitnessBuddyLocalDataSource {

    boolean isOutdated();

    boolean saveFitnessBuddies(List<FitnessBuddy> fitnessBuddies);

    List<FitnessBuddy> getFitnessBuddies(List<Integer> fitnessBuddyIDs);

}
