package com.kratos.keepfit.localdatasources.roomdb;

import com.kratos.keepfit.entities.Allergy;
import com.kratos.keepfit.localdatasources.interfaces.AllergyLocalDataSource;
import com.kratos.keepfit.localdatasources.roomdb.dao.AllergyDao;
import com.kratos.keepfit.utilities.interfaces.DateTimeUtility;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class AllergyLocalDataSourceImpl implements AllergyLocalDataSource {

    private final AllergyDao allergyDao;
    private final DateTimeUtility dateTimeUtility;

    @Inject
    public AllergyLocalDataSourceImpl(AllergyDao allergyDao, DateTimeUtility dateTimeUtility) {
        this.allergyDao = allergyDao;
        this.dateTimeUtility = dateTimeUtility;
    }

    @Override
    public boolean isOutdated() {
        Date todaysDate = new Date();
        Date lastUpdated = allergyDao.getDateOfLastUpdate();
        if (lastUpdated == null){
            return true;
        }
        long dayDifference = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated);
        return dayDifference > 1;
    }

    @Override
    public List<Allergy> getAllAllergies() {
        return allergyDao.getAllAllergiess();
    }

    @Override
    public boolean saveAllergies(List<Allergy> allergies) {
        allergyDao.insertAllergies(allergies);
        return true;
    }
}