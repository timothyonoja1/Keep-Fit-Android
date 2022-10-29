package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.datastores.interfaces.UserDataStore;
import com.kratos.keepfit.entities.Speciality;
import com.kratos.keepfit.localdatasources.interfaces.SpecialityLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.SpecialityRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.SpecialityRepository;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class SpecialityRepositoryImpl implements SpecialityRepository {

    private final UserDataStore userDataStore;
    private final SpecialityLocalDataSource specialityLocalDataSource;
    private final SpecialityRemoteDataSource specialityRemoteDataSource;

    @Inject
    public SpecialityRepositoryImpl(UserDataStore userDataStore,
                                    SpecialityLocalDataSource specialityLocalDataSource,
                                    SpecialityRemoteDataSource specialityRemoteDataSource) {
        this.userDataStore = userDataStore;
        this.specialityLocalDataSource = specialityLocalDataSource;
        this.specialityRemoteDataSource = specialityRemoteDataSource;
    }

    @Override
    public List<Speciality> getLoggedInUserSpecialities() {
        if (specialityLocalDataSource.isOutdated()) {
            refresh();
        }
        return specialityLocalDataSource.getAllLoggedInUserSpecialities();
    }

    private void refresh() {
        int userProfileID = userDataStore.getLoggedInUserProfile().getUserProfileID();
        List<Speciality> result = specialityRemoteDataSource.getSpecialities(userProfileID);
        Date currentDate = new Date();
        for (Speciality speciality : result) {
            speciality.setDateSavedToLocalDatabase(currentDate);
        }
        specialityLocalDataSource.saveSpecialities(result);
    }
}
