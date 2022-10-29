package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.FitnessBuddy;
import com.kratos.keepfit.localdatasources.interfaces.FitnessBuddyLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessBuddyLocalDataSource implements FitnessBuddyLocalDataSource {

    private final List<FitnessBuddy> fitnessBuddies = new ArrayList<>();

    @Inject
    public FakeFitnessBuddyLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return true;
    }

    @Override
    public boolean saveFitnessBuddies(List<FitnessBuddy> fitnessBuddies) {
        this.fitnessBuddies.clear();
        this.fitnessBuddies.addAll(fitnessBuddies);
        return true;
    }

    @Override
    public List<FitnessBuddy> getFitnessBuddies(List<Integer> fitnessBuddyIDs) {
        List<FitnessBuddy> result = new ArrayList<>();
        for (int fitnessBuddyID : fitnessBuddyIDs) {
            FitnessBuddy fitnessBuddy = getFitnessBuddy(fitnessBuddyID);
            if (fitnessBuddy != null) {
                result.add(fitnessBuddy);
            }
        }
        return result;
    }

    private FitnessBuddy getFitnessBuddy(int fitnessBuddyID) {
        for (FitnessBuddy fitnessBuddy : fitnessBuddies) {
            if (fitnessBuddy.getFitnessBuddyID() == fitnessBuddyID) {
                return fitnessBuddy;
            }
        }
        return null;
    }
}