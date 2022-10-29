package com.kratos.keepfit.datastores.real;

import android.content.Context;
import android.content.SharedPreferences;
import com.kratos.keepfit.datastores.interfaces.WeeklyTrainingDurationDataStore;
import javax.inject.Inject;
import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.qualifiers.ApplicationContext;

public class WeeklyTrainingDurationDataStoreImpl implements WeeklyTrainingDurationDataStore {

    private final Context context;

    @Inject
    public WeeklyTrainingDurationDataStoreImpl(@ApplicationContext Context context) {
        this.context = context;
    }

    @Override
    public int getSavedWeeklyTrainingDurationIDOfLoggedInUser() {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);

        return sharedPref.getInt("weeklyTrainingDurationIDofUser", 0);
    }

    @Override
    public boolean saveWeeklyTrainingDurationIDofUser(int weeklyTrainingDurationID) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("weeklyTrainingDurationIDofUser", weeklyTrainingDurationID);
        editor.apply();

        return true;
    }
}
