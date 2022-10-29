package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import com.kratos.keepfit.localdatasources.interfaces.WeeklyTrainingDurationLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeWeeklyTrainingDurationLocalDataSource implements WeeklyTrainingDurationLocalDataSource {

    private final List<WeeklyTrainingDuration> weeklyTrainingDurations = new ArrayList<>();

    @Inject
    public FakeWeeklyTrainingDurationLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return true;
    }

    @Override
    public List<WeeklyTrainingDuration> getAllWeeklyTrainingDurations() {
        return weeklyTrainingDurations;
    }

    @Override
    public boolean saveWeeklyTrainingDurations(List<WeeklyTrainingDuration> weeklyTrainingDurations) {
        this.weeklyTrainingDurations.clear();
        this.weeklyTrainingDurations.addAll(weeklyTrainingDurations);
        return true;
    }
}
