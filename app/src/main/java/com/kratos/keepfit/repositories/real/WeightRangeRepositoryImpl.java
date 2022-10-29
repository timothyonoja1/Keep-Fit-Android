package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.datastores.interfaces.WeightRangeDataStore;
import com.kratos.keepfit.entities.WeightRange;
import com.kratos.keepfit.localdatasources.interfaces.WeightRangeLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.WeightRangeRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.WeightRangeRepository;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class WeightRangeRepositoryImpl implements WeightRangeRepository {

    private final WeightRangeDataStore weightRangeDataStore;
    private final WeightRangeLocalDataSource weightRangeLocalDataSource;
    private final WeightRangeRemoteDataSource weightRangeRemoteDataSource;

    @Inject
    public WeightRangeRepositoryImpl(WeightRangeDataStore weightRangeDataStore,
                                     WeightRangeLocalDataSource weightRangeLocalDataSource,
                                     WeightRangeRemoteDataSource weightRangeRemoteDataSource) {
        this.weightRangeDataStore = weightRangeDataStore;
        this.weightRangeLocalDataSource = weightRangeLocalDataSource;
        this.weightRangeRemoteDataSource = weightRangeRemoteDataSource;
    }

    @Override
    public boolean saveWeightSelectedByUser(int weight) {
        int weightRangeID = getWeightRangeID(weight, getAllWeightRanges());
        weightRangeDataStore.saveWeightRangeIDSelectedByUser(weightRangeID);
        weightRangeDataStore.saveWeightSelectedByUser(weight);
        return true;
    }

    @Override
    public int getWeightSelectedByUser() {
        return weightRangeDataStore.getWeightSelectedByUser();
    }

    @Override
    public int getWeightRangeIDSelectedBUser() {
        return weightRangeDataStore.getWeightRangeIDSelectedByUser();
    }

    @Override
    public List<WeightRange> getAllWeightRanges() {
        if (weightRangeLocalDataSource.isOutdated()) {
            refresh();
        }
        return weightRangeRemoteDataSource.getAllWeightRanges();
    }

    @Override
    public boolean deleteWeightSelectedByUser() {
        weightRangeDataStore.deleteWeightSelectedByUser();
        weightRangeDataStore.deleteWeightRangeSelectedByUser();
        return true;
    }

    private int getWeightRangeID(int weight, List<WeightRange> weightRanges) {
        for (WeightRange weightRange : weightRanges) {
            if (weight >= weightRange.getMinimumWeightInKg() && weight <= weightRange.getMinimumWeightInKg()) {
                return weightRange.getWeightRangeID();
            }
        }
        // If we get this far, no appropriate ageRange
        return 0;
    }

    private void refresh() {
        List<WeightRange> result = weightRangeRemoteDataSource.getAllWeightRanges();
        Date currentDate = new Date();
        for (WeightRange weightRange : result) {
            weightRange.setDateSavedToLocalDatabase(currentDate);
        }
        weightRangeLocalDataSource.saveWeightRanges(result);
    }
}