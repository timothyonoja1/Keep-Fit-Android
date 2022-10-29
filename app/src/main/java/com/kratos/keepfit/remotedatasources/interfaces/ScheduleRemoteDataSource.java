package com.kratos.keepfit.remotedatasources.interfaces;

import com.kratos.keepfit.entities.Schedule;
import java.util.List;

public interface ScheduleRemoteDataSource {

    List<Schedule> getSchedules(int userProfileID);

}
