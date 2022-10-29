package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.FitnessBuddy;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessBuddyRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessBuddyRemoteDataSource implements FitnessBuddyRemoteDataSource {

    private final List<FitnessBuddy> fitnessBuddies = new ArrayList<>();

    @Inject
    public FakeFitnessBuddyRemoteDataSource() {

    }

    @Override
    public List<FitnessBuddy> getAllFitnessBuddies() {
        return fitnessBuddies;
    }
}