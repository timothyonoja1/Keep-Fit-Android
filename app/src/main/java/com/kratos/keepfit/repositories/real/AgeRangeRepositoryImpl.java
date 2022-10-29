package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.datastores.interfaces.AgeRangeDataStore;
import com.kratos.keepfit.entities.AgeRange;
import com.kratos.keepfit.localdatasources.interfaces.AgeRangeLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.AgeRangeRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.AgeRangeRepository;

import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class AgeRangeRepositoryImpl implements AgeRangeRepository {

    private final AgeRangeDataStore ageRangeDataStore;
    private final AgeRangeLocalDataSource ageRangeLocalDataSource;
    private final AgeRangeRemoteDataSource ageRangeRemoteDataSource;

    @Inject
    public AgeRangeRepositoryImpl(AgeRangeDataStore ageRangeDataStore,
                                  AgeRangeLocalDataSource ageRangeLocalDataSource,
                                  AgeRangeRemoteDataSource ageRangeRemoteDataSource) {
        this.ageRangeDataStore = ageRangeDataStore;
        this.ageRangeLocalDataSource = ageRangeLocalDataSource;
        this.ageRangeRemoteDataSource = ageRangeRemoteDataSource;
    }

    @Override
    public boolean saveAgeSelectedByUser(int age) {
        int ageRangeID = getAgeRangeID(age, getAllAgeRanges());
        ageRangeDataStore.saveAgeRangeIDSelectedByUser(ageRangeID);
        ageRangeDataStore.saveAgeSelectedByUser(age);
        return false;
    }

    @Override
    public boolean deleteAgeSelectedByUser() {
        ageRangeDataStore.deleteAgeSelectedByUser();
        ageRangeDataStore.deleteAgeRangeSelectedByUser();
        return true;
    }

    @Override
    public int getAgeSelectedByUser() {
        return ageRangeDataStore.getAgeSelectedByUser();
    }

    @Override
    public int getAgeRangeIDSelectedByUser() {
        return ageRangeDataStore.getAgeRangeIDSelectedByUser();
    }

    @Override
    public List<AgeRange> getAllAgeRanges() {
        if (ageRangeLocalDataSource.isOutdated()) {
            refresh();
        }
        return ageRangeLocalDataSource.getAllAgeRanges();
    }

    private int getAgeRangeID(int age, List<AgeRange> ageRanges) {
        for (AgeRange ageRange : ageRanges) {
            if (age >= ageRange.getMinimumAge() && age <= ageRange.getMaximumAge()) {
                return ageRange.getAgeRangeID();
            }
        }
        // If we get this far, no appropriate ageRange
        return 0;
    }

    private void refresh() {
        List<AgeRange> result = ageRangeRemoteDataSource.getAllAgeRanges();
        Date currentDate = new Date();
        for (AgeRange ageRange : result) {
            ageRange.setDateSavedToLocalDatabase(currentDate);
        }
        ageRangeLocalDataSource.saveAgeRanges(result);
    }
}