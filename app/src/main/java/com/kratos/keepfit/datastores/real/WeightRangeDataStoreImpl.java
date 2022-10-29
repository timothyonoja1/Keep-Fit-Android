package com.kratos.keepfit.datastores.real;

import android.content.Context;
import android.content.SharedPreferences;

import com.kratos.keepfit.datastores.interfaces.WeightRangeDataStore;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.qualifiers.ApplicationContext;

public class WeightRangeDataStoreImpl implements WeightRangeDataStore {

    private final Context context;

    @Inject
    public WeightRangeDataStoreImpl(@ApplicationContext Context context) {
        this.context = context;
    }

    @Override
    public boolean saveWeightSelectedByUser(int weight) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("weightSelectedByUser", weight);
        editor.apply();

        return true;
    }

    @Override
    public boolean saveWeightRangeIDSelectedByUser(int weightRangeID) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("weightRangeIDSelectedByUser", weightRangeID);
        editor.apply();

        return true;
    }

    @Override
    public int getWeightSelectedByUser() {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);

        return sharedPref.getInt("weightSelectedByUser", 0);
    }

    @Override
    public int getWeightRangeIDSelectedByUser() {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);

        return sharedPref.getInt("weightRangeIDSelectedByUser", 0);
    }

    @Override
    public boolean deleteWeightSelectedByUser() {
        return saveWeightSelectedByUser(0);
    }

    @Override
    public boolean deleteWeightRangeSelectedByUser() {
        return saveWeightRangeIDSelectedByUser(0);
    }
}