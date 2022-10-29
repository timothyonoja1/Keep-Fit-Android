package com.kratos.keepfit.localdatasources.roomdb;

import com.kratos.keepfit.entities.AgeRange;
import com.kratos.keepfit.localdatasources.interfaces.AgeRangeLocalDataSource;
import com.kratos.keepfit.localdatasources.roomdb.dao.AgeRangeDao;
import com.kratos.keepfit.utilities.interfaces.DateTimeUtility;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class AgeRangeLocalDataSourceImpl implements AgeRangeLocalDataSource {

    private final AgeRangeDao ageRangeDao;
    private final DateTimeUtility dateTimeUtility;

    @Inject
    public AgeRangeLocalDataSourceImpl(AgeRangeDao ageRangeDao, DateTimeUtility dateTimeUtility) {
        this.ageRangeDao = ageRangeDao;
        this.dateTimeUtility = dateTimeUtility;
    }

    @Override
    public boolean isOutdated() {
        Date todaysDate = new Date();
        Date lastUpdated = ageRangeDao.getDateOfLastUpdate();
        if (lastUpdated == null){
            return true;
        }
        long dayDifference = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated);
        return dayDifference > 1;
    }

    @Override
    public boolean saveAgeRanges(List<AgeRange> ageRanges) {
        ageRangeDao.insertAgeRanges(ageRanges);
        return true;
    }

    @Override
    public List<AgeRange> getAllAgeRanges() {
        return ageRangeDao.getAllAgeRanges();
    }
}