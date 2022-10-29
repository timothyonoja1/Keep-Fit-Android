package com.kratos.keepfit.repositories.interfaces;

import com.kratos.keepfit.entities.Schedule;
import java.util.List;

public interface ScheduleRepository {

    List<Schedule> getLoggedInUserSchedules();

}
