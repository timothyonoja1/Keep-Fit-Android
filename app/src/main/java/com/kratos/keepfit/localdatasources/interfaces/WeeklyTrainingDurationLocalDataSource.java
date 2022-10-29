package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import java.util.List;

public interface WeeklyTrainingDurationLocalDataSource {

    boolean isOutdated();

    List<WeeklyTrainingDuration> getAllWeeklyTrainingDurations();

    boolean saveWeeklyTrainingDurations(List<WeeklyTrainingDuration> weeklyTrainingDurations);

}
