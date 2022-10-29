package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.Schedule;
import java.util.List;

public interface ScheduleLocalDataSource {

    boolean isOutdated();

    boolean saveSchedules(List<Schedule> schedules);

    List<Schedule> getAllLoggedInUserSchedules();

    boolean deleteAllSchedules();

}
