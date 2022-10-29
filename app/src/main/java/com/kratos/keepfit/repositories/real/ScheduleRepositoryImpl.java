package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.datastores.interfaces.UserDataStore;
import com.kratos.keepfit.entities.AgeRange;
import com.kratos.keepfit.entities.Schedule;
import com.kratos.keepfit.localdatasources.interfaces.ScheduleLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.ScheduleRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.ScheduleRepository;

import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class ScheduleRepositoryImpl implements ScheduleRepository {

    private final UserDataStore userDataStore;
    private final ScheduleLocalDataSource scheduleLocalDataSource;
    private final ScheduleRemoteDataSource scheduleRemoteDataSource;

    @Inject
    public ScheduleRepositoryImpl(UserDataStore userDataStore,
                                  ScheduleLocalDataSource scheduleLocalDataSource,
                                  ScheduleRemoteDataSource scheduleRemoteDataSource) {
        this.userDataStore = userDataStore;
        this.scheduleLocalDataSource = scheduleLocalDataSource;
        this.scheduleRemoteDataSource = scheduleRemoteDataSource;
    }


    @Override
    public List<Schedule> getLoggedInUserSchedules() {
        if (scheduleLocalDataSource.isOutdated()) {
            refresh();
        }
        return scheduleLocalDataSource.getAllLoggedInUserSchedules();
    }

    private void refresh() {
        int userProfileID = userDataStore.getLoggedInUserProfile().getUserProfileID();
        List<Schedule> result = scheduleRemoteDataSource.getSchedules(userProfileID);
        Date currentDate = new Date();
        for (Schedule schedule : result) {
            schedule.setDateSavedToLocalDatabase(currentDate);
        }
        scheduleLocalDataSource.saveSchedules(result);
    }
}
