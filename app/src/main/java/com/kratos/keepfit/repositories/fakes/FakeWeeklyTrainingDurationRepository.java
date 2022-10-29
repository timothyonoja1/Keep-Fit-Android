package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import com.kratos.keepfit.repositories.interfaces.WeeklyTrainingDurationRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeWeeklyTrainingDurationRepository implements WeeklyTrainingDurationRepository {

    private int weeklyTrainingDurationID;

    @Inject
    public FakeWeeklyTrainingDurationRepository()
    {

    }

    @Override
    public List<WeeklyTrainingDuration> getAllWeeklyTrainingDurations() {
        return getMockWeeklyTrainingDurations();
    }

    @Override
    public int getSavedWeeklyTrainingDurationIDOfLoggedInUser() {
        return weeklyTrainingDurationID;
    }

    @Override
    public boolean saveWeeklyTrainingDurationIDofUser(int weeklyTrainingDurationID) {
        this.weeklyTrainingDurationID = weeklyTrainingDurationID;
        return false;
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
