package com.kratos.keepfit.datastores.real;

import android.content.Context;
import android.content.SharedPreferences;
import com.kratos.keepfit.datastores.interfaces.AgeRangeDataStore;
import javax.inject.Inject;
import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.qualifiers.ApplicationContext;

public class AgeRangeDataStoreImpl implements AgeRangeDataStore {

    private final Context context;

    @Inject
    public AgeRangeDataStoreImpl(@ApplicationContext Context context){
        this.context = context;
    }

    @Override
    public boolean saveAgeSelectedByUser(int age) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("ageSelectedByUser", age);
        editor.apply();

        return true;
    }

    @Override
    public boolean saveAgeRangeIDSelectedByUser(int ageRangeID) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("ageRangeIDSelectedByUser", ageRangeID);
        editor.apply();

        return true;
    }

    @Override
    public int getAgeSelectedByUser() {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);

        return sharedPref.getInt("ageSelectedByUser", 0);
    }

    @Override
    public int getAgeRangeIDSelectedByUser() {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);

        return sharedPref.getInt("ageRangeIDSelectedByUser", 0);
    }

    @Override
    public boolean deleteAgeSelectedByUser() {
        saveAgeSelectedByUser(0);
        return true;
    }

    @Override
    public boolean deleteAgeRangeSelectedByUser() {
        saveAgeRangeIDSelectedByUser(0);
        return true;
    }
}
