package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.datastores.interfaces.HeightRangeDataStore;
import com.kratos.keepfit.entities.AgeRange;
import com.kratos.keepfit.entities.HeightRange;
import com.kratos.keepfit.localdatasources.interfaces.HeightRangeLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.HeightRangeRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.HeightRangeRepository;

import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class HeightRangeRepositoryImpl implements HeightRangeRepository {

    private final HeightRangeDataStore heightRangeDataStore;
    private final HeightRangeLocalDataSource heightRangeLocalDataSource;
    private final HeightRangeRemoteDataSource heightRangeRemoteDataSource;

    @Inject
    public HeightRangeRepositoryImpl(
            HeightRangeDataStore heightRangeDataStore,
            HeightRangeLocalDataSource heightRangeLocalDataSource,
            HeightRangeRemoteDataSource heightRangeRemoteDataSource) {
        this.heightRangeDataStore = heightRangeDataStore;
        this.heightRangeLocalDataSource = heightRangeLocalDataSource;
        this.heightRangeRemoteDataSource = heightRangeRemoteDataSource;
    }

    @Override
    public boolean saveHeightSelectedByUser(int height) {
        int heightRangeID = getHeightRangeID(height, getAllHeightRanges());
        heightRangeDataStore.saveHeightRangeIDSelectedByUser(heightRangeID);
        heightRangeDataStore.saveHeightSelectedByUser(height);
        return true;
    }

    @Override
    public int getHeightSelectedByUser() {
        return heightRangeDataStore.getHeightSelectedByUser();
    }

    @Override
    public int getHeightRangeIDSelectedBUser() {
        return heightRangeDataStore.getHeightRangeIDSelectedByUser();
    }

    @Override
    public List<HeightRange> getAllHeightRanges() {
        if (heightRangeLocalDataSource.isOutdated()) {
            refresh();
        }
        return heightRangeLocalDataSource.getAllHeightRanges();
    }

    @Override
    public boolean deleteHeightSelectedByUser() {
        heightRangeDataStore.deleteHeightSelectedByUser();
        heightRangeDataStore.deleteHeightRangeSelectedByUser();
        return true;
    }

    private int getHeightRangeID(int height, List<HeightRange> heightRanges) {
        for (HeightRange heightRange : heightRanges) {
            if (height >= heightRange.getMinimumHeightInCM() && height <= heightRange.getMaximumHeightInCM()) {
                return heightRange.getHeightRangeID();
            }
        }
        // If we get this far, no appropriate ageRange
        return 0;
    }

    private void refresh() {
        List<HeightRange> result = heightRangeRemoteDataSource.getAllHeightRanges();
        Date currentDate = new Date();
        for (HeightRange heightRange : result) {
            heightRange.setDateSavedToLocalDatabase(currentDate);
        }
        heightRangeLocalDataSource.saveHeightRanges(result);
    }
}
