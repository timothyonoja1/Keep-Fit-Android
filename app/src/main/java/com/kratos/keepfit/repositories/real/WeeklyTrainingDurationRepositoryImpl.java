package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.datastores.interfaces.WeeklyTrainingDurationDataStore;
import com.kratos.keepfit.entities.AgeRange;
import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import com.kratos.keepfit.localdatasources.interfaces.WeeklyTrainingDurationLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.WeeklyTrainingDurationRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.WeeklyTrainingDurationRepository;

import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class WeeklyTrainingDurationRepositoryImpl implements WeeklyTrainingDurationRepository {

    private final WeeklyTrainingDurationDataStore weeklyTrainingDurationDataStore;
    private final WeeklyTrainingDurationLocalDataSource weeklyTrainingDurationLocalDataSource;
    private final WeeklyTrainingDurationRemoteDataSource weeklyTrainingDurationRemoteDataSource;

    @Inject
    public WeeklyTrainingDurationRepositoryImpl(
            WeeklyTrainingDurationDataStore weeklyTrainingDurationDataStore,
            WeeklyTrainingDurationLocalDataSource weeklyTrainingDurationLocalDataSource,
            WeeklyTrainingDurationRemoteDataSource weeklyTrainingDurationRemoteDataSource) {
        this.weeklyTrainingDurationDataStore = weeklyTrainingDurationDataStore;
        this.weeklyTrainingDurationLocalDataSource = weeklyTrainingDurationLocalDataSource;
        this.weeklyTrainingDurationRemoteDataSource = weeklyTrainingDurationRemoteDataSource;
    }

    @Override
    public List<WeeklyTrainingDuration> getAllWeeklyTrainingDurations() {
        if (weeklyTrainingDurationLocalDataSource.isOutdated()){
            refreshWeeklyTrainingDurationLocalDataSource();
        }
        return weeklyTrainingDurationLocalDataSource.getAllWeeklyTrainingDurations();
    }

    @Override
    public int getSavedWeeklyTrainingDurationIDOfLoggedInUser() {
        return weeklyTrainingDurationDataStore.getSavedWeeklyTrainingDurationIDOfLoggedInUser();
    }

    @Override
    public boolean saveWeeklyTrainingDurationIDofUser(int weeklyTrainingDurationID) {
        return weeklyTrainingDurationDataStore.saveWeeklyTrainingDurationIDofUser(weeklyTrainingDurationID);
    }

    private void refreshWeeklyTrainingDurationLocalDataSource() {
        List<WeeklyTrainingDuration> result
                = weeklyTrainingDurationRemoteDataSource.getAllWeeklyTrainingDurations();
        Date currentDate = new Date();
        for (WeeklyTrainingDuration weeklyTrainingDuration : result) {
            weeklyTrainingDuration.setDateSavedToLocalDatabase(currentDate);
        }
        weeklyTrainingDurationLocalDataSource.saveWeeklyTrainingDurations(result);
    }
}
