package com.kratos.keepfit.datastores.real;

import android.content.Context;
import android.content.SharedPreferences;
import com.kratos.keepfit.datastores.interfaces.HeightRangeDataStore;
import javax.inject.Inject;
import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.qualifiers.ApplicationContext;

public class HeightRangeDataStoreImpl implements HeightRangeDataStore {

    private final Context context;

    @Inject
    public HeightRangeDataStoreImpl(@ApplicationContext Context context) {
        this.context = context;
    }

    @Override
    public boolean saveHeightSelectedByUser(int height) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("heightSelectedByUser", height);
        editor.apply();

        return true;
    }

    @Override
    public boolean saveHeightRangeIDSelectedByUser(int heightRangeID) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("heightRangeIDSelectedByUser", heightRangeID);
        editor.apply();

        return true;
    }

    @Override
    public int getHeightSelectedByUser() {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);

        return sharedPref.getInt("heightSelectedByUser", 0);

    }

    @Override
    public int getHeightRangeIDSelectedByUser() {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);

        return sharedPref.getInt("heightRangeIDSelectedByUser", 0);
    }

    @Override
    public boolean deleteHeightSelectedByUser() {
        saveHeightSelectedByUser(0);
        return true;
    }

    @Override
    public boolean deleteHeightRangeSelectedByUser() {
        saveHeightRangeIDSelectedByUser(0);
        return true;
    }
}