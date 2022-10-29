package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.entities.FitnessBuddy;
import com.kratos.keepfit.repositories.interfaces.FitnessBuddyRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessBuddyRepository implements FitnessBuddyRepository {

    private final List<FitnessBuddy> fitnessBuddies = new ArrayList<>();

    @Inject
    public FakeFitnessBuddyRepository() {

    }

    @Override
    public List<FitnessBuddy> getFitnessBuddies(List<Integer> fitnessBuddyIDs) {
        List<FitnessBuddy> result = new ArrayList<>();
        for (Integer fitnessBuddyID : fitnessBuddyIDs) {
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
