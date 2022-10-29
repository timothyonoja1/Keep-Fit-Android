package com.kratos.keepfit.datastores.interfaces;

public interface HeightRangeDataStore {

    boolean saveHeightSelectedByUser(int height);

    boolean saveHeightRangeIDSelectedByUser(int heightRangeID);

    int getHeightSelectedByUser();

    int getHeightRangeIDSelectedByUser();

    boolean deleteHeightSelectedByUser();

    boolean deleteHeightRangeSelectedByUser();

}
