package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.entities.Schedule;
import com.kratos.keepfit.repositories.interfaces.ScheduleRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeScheduleRepository implements ScheduleRepository {

    private final List<Schedule> schedules;
    @Inject
    public FakeScheduleRepository() {
        schedules = new ArrayList<>();
    }

    @Override
    public List<Schedule> getLoggedInUserSchedules() {
        return getMockSchedules();
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
