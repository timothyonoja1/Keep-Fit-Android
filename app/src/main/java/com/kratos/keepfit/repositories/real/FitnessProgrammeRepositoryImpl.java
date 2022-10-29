package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.entities.FitnessProgramme;
import com.kratos.keepfit.localdatasources.interfaces.FitnessProgrammeLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessProgrammeRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.FitnessProgrammeRepository;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class FitnessProgrammeRepositoryImpl implements FitnessProgrammeRepository {

    private final FitnessProgrammeLocalDataSource fitnessProgrammeLocalDataSource;
    private final FitnessProgrammeRemoteDataSource fitnessProgrammeRemoteDataSource;

    @Inject
    public FitnessProgrammeRepositoryImpl(
            FitnessProgrammeLocalDataSource fitnessProgrammeLocalDataSource,
            FitnessProgrammeRemoteDataSource fitnessProgrammeRemoteDataSource) {

        this.fitnessProgrammeLocalDataSource = fitnessProgrammeLocalDataSource;
        this.fitnessProgrammeRemoteDataSource = fitnessProgrammeRemoteDataSource;
    }

    @Override
    public List<FitnessProgramme> getFitnessProgrammes(List<Integer> fitnessProgrammeIDs) {
        if (fitnessProgrammeLocalDataSource.isOutdated()) {
            refreshFitnessProgrammeLocalDataSource();
        }
        return fitnessProgrammeLocalDataSource.getFitnessProgrammes(fitnessProgrammeIDs);
    }

    public void refreshFitnessProgrammeLocalDataSource() {
        List<FitnessProgramme> result = fitnessProgrammeRemoteDataSource.getAllFitnessProgrammes();
        Date currentDate = new Date();
        for (FitnessProgramme fitnessProgramme : result) {
            fitnessProgramme.setDateSavedToLocalDatabase(currentDate);
        }
        fitnessProgrammeLocalDataSource.saveFitnessProgrammes(result);
    }
}
