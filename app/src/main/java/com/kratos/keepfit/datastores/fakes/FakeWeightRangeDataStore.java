package com.kratos.keepfit.datastores.fakes;

import com.kratos.keepfit.datastores.interfaces.WeightRangeDataStore;
import javax.inject.Inject;

public class FakeWeightRangeDataStore implements WeightRangeDataStore {

    private int weight;
    private int weightRangeID;

    @Inject
    public FakeWeightRangeDataStore() {

    }

    @Override
    public boolean saveWeightSelectedByUser(int weight) {
        this.weight = weight;
        return true;
    }

    @Override
    public boolean saveWeightRangeIDSelectedByUser(int weightRangeID) {
        this.weightRangeID = weightRangeID;
        return false;
    }

    @Override
    public int getWeightSelectedByUser() {
        return weight;
    }

    @Override
    public int getWeightRangeIDSelectedByUser() {
        return weightRangeID;
    }

    @Override
    public boolean deleteWeightSelectedByUser() {
        weight = 0;
        return true;
    }

    @Override
    public boolean deleteWeightRangeSelectedByUser() {
        weightRangeID = 0;
        return true;
    }
}
