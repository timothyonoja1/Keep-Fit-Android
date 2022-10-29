package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.entities.Allergy;
import com.kratos.keepfit.localdatasources.interfaces.AllergyLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.AllergyRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.AllergyRepository;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class AllergyRepositoryImpl implements AllergyRepository {

    private final AllergyLocalDataSource allergyLocalDataSource;
    private final AllergyRemoteDataSource allergyRemoteDataSource;

    @Inject
    public AllergyRepositoryImpl(AllergyLocalDataSource allergyLocalDataSource,
                                 AllergyRemoteDataSource allergyRemoteDataSource) {
        this.allergyLocalDataSource = allergyLocalDataSource;
        this.allergyRemoteDataSource = allergyRemoteDataSource;
    }

    @Override
    public List<Allergy> getAllAllergies() {
        if (allergyLocalDataSource.isOutdated()){
            refreshAllergyLocalDataSource();
        }
        return allergyLocalDataSource.getAllAllergies();
    }

    private void refreshAllergyLocalDataSource() {
        List<Allergy> allergies = allergyRemoteDataSource.getAllAllergies();
        Date currentDate = new Date();
        for (Allergy allergy : allergies) {
            allergy.setDateSavedToLocalDatabase(currentDate);
        }
        allergyLocalDataSource.saveAllergies(allergies);
    }
}
