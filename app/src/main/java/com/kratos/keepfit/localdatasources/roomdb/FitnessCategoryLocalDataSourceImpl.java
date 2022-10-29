package com.kratos.keepfit.localdatasources.roomdb;

import com.kratos.keepfit.entities.FitnessCategory;
import com.kratos.keepfit.localdatasources.interfaces.FitnessCategoryLocalDataSource;
import com.kratos.keepfit.localdatasources.roomdb.dao.FitnessCategoryDao;
import com.kratos.keepfit.utilities.interfaces.DateTimeUtility;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class FitnessCategoryLocalDataSourceImpl implements FitnessCategoryLocalDataSource {

    private final FitnessCategoryDao fitnessCategoryDao;
    private final DateTimeUtility dateTimeUtility;

    @Inject
    public FitnessCategoryLocalDataSourceImpl(FitnessCategoryDao fitnessCategoryDao,
                                              DateTimeUtility dateTimeUtility) {
        this.fitnessCategoryDao = fitnessCategoryDao;
        this.dateTimeUtility = dateTimeUtility;
    }

    @Override
    public boolean isOutdated() {
        Date todaysDate = new Date();
        Date lastUpdated = fitnessCategoryDao.getDateOfLastUpdate();
        if (lastUpdated == null){
            return true;
        }
        long dayDifference = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated);
        return dayDifference > 1;
    }

    @Override
    public List<FitnessCategory> getAllFitnessCategories() {
        return fitnessCategoryDao.getAllFitnessCategories();
    }

    @Override
    public boolean saveFitnessCategories(List<FitnessCategory> fitnessCategories) {
        fitnessCategoryDao.insertFitnessCategories(fitnessCategories);
        return true;
    }
}