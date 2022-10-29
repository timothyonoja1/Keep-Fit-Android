package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.Schedule;
import com.kratos.keepfit.localdatasources.interfaces.ScheduleLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeScheduleLocalDataSource implements ScheduleLocalDataSource {

    private final List<Schedule> schedules = new ArrayList<>();

    @Inject
    public FakeScheduleLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return true;
    }

    @Override
    public boolean saveSchedules(List<Schedule> schedules) {
        this.schedules.clear();
        this.schedules.addAll(schedules);
        return true;
    }

    @Override
    public List<Schedule> getAllLoggedInUserSchedules() {
        return schedules;
    }

    @Override
    public boolean deleteAllSchedules() {
        schedules.clear();
        return true;
    }
}
