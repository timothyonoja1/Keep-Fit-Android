package com.kratos.keepfit.datastores.interfaces;

public interface WeightRangeDataStore {

    boolean saveWeightSelectedByUser(int weight);

    boolean saveWeightRangeIDSelectedByUser(int weightRangeID);

    int getWeightSelectedByUser();

    int getWeightRangeIDSelectedByUser();

    boolean deleteWeightSelectedByUser();

    boolean deleteWeightRangeSelectedByUser();

}