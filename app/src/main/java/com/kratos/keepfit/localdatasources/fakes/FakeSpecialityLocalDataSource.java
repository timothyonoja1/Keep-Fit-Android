package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.Speciality;
import com.kratos.keepfit.localdatasources.interfaces.SpecialityLocalDataSource;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeSpecialityLocalDataSource implements SpecialityLocalDataSource {

    private final List<Speciality> specialities = new ArrayList<>();

    @Inject
    public FakeSpecialityLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return true;
    }

    @Override
    public boolean saveSpecialities(List<Speciality> specialities) {
        this.specialities.clear();
        this.specialities.addAll(specialities);
        return false;
    }

    @Override
    public List<Speciality> getAllLoggedInUserSpecialities() {
        return specialities;
    }

    @Override
    public boolean deleteAllSpecialities() {
        specialities.clear();
        return true;
    }
}
