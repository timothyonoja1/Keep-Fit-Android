package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.Schedule;
import com.kratos.keepfit.remotedatasources.interfaces.ScheduleRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeScheduleRemoteDataSource implements ScheduleRemoteDataSource {

    private final List<Schedule> schedules;

    @Inject
    public FakeScheduleRemoteDataSource() {
        schedules = new ArrayList<>();
    }

    @Override
    public List<Schedule> getSchedules(int userProfileID) {
        return schedules;
    }

    private List<Schedule> getMockSchedules() {
        List<Schedule> schedules = new ArrayList<>();
        schedules.add(new Schedule(1, "07:30 AM", "Available"));
        schedules.add(new Schedule(2, "08:00 AM", "Available"));
        schedules.add(new Schedule(3, "08:00 AM", "Booked"));
        schedules.add(new Schedule(4, "08:30 AM", "Booked"));

        return schedules;
    }
}