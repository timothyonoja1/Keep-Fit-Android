package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.entities.FitnessBuddy;
import com.kratos.keepfit.localdatasources.interfaces.FitnessBuddyLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessBuddyRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.FitnessBuddyRepository;
import java.util.List;
import javax.inject.Inject;

public class FitnessBuddyRepositoryImpl implements FitnessBuddyRepository {

    private final FitnessBuddyLocalDataSource fitnessBuddyLocalDataSource;
    private final FitnessBuddyRemoteDataSource fitnessBuddyRemoteDataSource;

    @Inject
    public FitnessBuddyRepositoryImpl(FitnessBuddyLocalDataSource fitnessBuddyLocalDataSource,
                                      FitnessBuddyRemoteDataSource fitnessBuddyRemoteDataSource) {
        this.fitnessBuddyLocalDataSource = fitnessBuddyLocalDataSource;
        this.fitnessBuddyRemoteDataSource = fitnessBuddyRemoteDataSource;
    }

    @Override
    public List<FitnessBuddy> getFitnessBuddies(List<Integer> fitnessBuddyIDs) {
        if (fitnessBuddyLocalDataSource.isOutdated()) {
            refresh();
        }
        return fitnessBuddyLocalDataSource.getFitnessBuddies(fitnessBuddyIDs);
    }

    private void refresh() {
        List<FitnessBuddy> fitnessBuddies = fitnessBuddyRemoteDataSource.getAllFitnessBuddies();
        fitnessBuddyLocalDataSource.saveFitnessBuddies(fitnessBuddies);
    }
}