package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import com.kratos.keepfit.remotedatasources.interfaces.WeeklyTrainingDurationRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeWeeklyTrainingDurationRemoteDataSource implements WeeklyTrainingDurationRemoteDataSource {

    @Inject
    public FakeWeeklyTrainingDurationRemoteDataSource() {

    }

    @Override
    public List<WeeklyTrainingDuration> getAllWeeklyTrainingDurations() {
        return getMockWeeklyTrainingDurations();
    }

    private List<WeeklyTrainingDuration> getMockWeeklyTrainingDurations(){
        List<WeeklyTrainingDuration> weeklyTrainingDurations = new ArrayList<>();
        weeklyTrainingDurations.add(new WeeklyTrainingDuration(
                1, 1, 2, "1-2 Days"
        ));
        weeklyTrainingDurations.add(new WeeklyTrainingDuration(
                2, 3, 4, "3-4 Days"
        ));
        weeklyTrainingDurations.add(new WeeklyTrainingDuration(
                3, 5, 7, "5+ Days"
        ));

        return weeklyTrainingDurations;
    }
}
