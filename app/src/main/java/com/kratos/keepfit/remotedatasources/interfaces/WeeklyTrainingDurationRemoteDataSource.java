package com.kratos.keepfit.remotedatasources.interfaces;

import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import java.util.List;

public interface WeeklyTrainingDurationRemoteDataSource {

    List<WeeklyTrainingDuration> getAllWeeklyTrainingDurations();

}
