package com.kratos.keepfit.repositories.interfaces;

import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import java.util.List;

public interface WeeklyTrainingDurationRepository {

    List<WeeklyTrainingDuration> getAllWeeklyTrainingDurations();

    int getSavedWeeklyTrainingDurationIDOfLoggedInUser();

    boolean saveWeeklyTrainingDurationIDofUser(int weeklyTrainingDurationID);

}
