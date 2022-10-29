package com.kratos.keepfit.datastores.fakes;

import com.kratos.keepfit.datastores.interfaces.HeightRangeDataStore;
import javax.inject.Inject;

public class FakeHeightRangeDataStore implements HeightRangeDataStore {

    private int height;
    private int heightRangeID;
    @Inject
    public FakeHeightRangeDataStore() {

    }

    @Override
    public boolean saveHeightSelectedByUser(int height) {
        this.height = height;
        return true;
    }

    @Override
    public boolean saveHeightRangeIDSelectedByUser(int heightRangeID) {
        this.heightRangeID = heightRangeID;
        return true;
    }

    @Override
    public int getHeightSelectedByUser() {
        return height;
    }

    @Override
    public int getHeightRangeIDSelectedByUser() {
        return heightRangeID;
    }

    @Override
    public boolean deleteHeightSelectedByUser() {
        height = 0;
        return true;
    }

    @Override
    public boolean deleteHeightRangeSelectedByUser() {
        heightRangeID = 0;
        return true;
    }
}