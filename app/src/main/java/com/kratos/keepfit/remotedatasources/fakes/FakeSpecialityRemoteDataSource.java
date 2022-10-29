package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.Speciality;
import com.kratos.keepfit.remotedatasources.interfaces.SpecialityRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeSpecialityRemoteDataSource implements SpecialityRemoteDataSource {

    private final List<Speciality> specialities;

    @Inject
    public FakeSpecialityRemoteDataSource() {
        specialities = new ArrayList<>();
    }

    @Override
    public List<Speciality> getSpecialities(int userProfileID) {
        return specialities;
    }

    private List<Speciality> getMockSpecialities() {
        List<Speciality> specialities = new ArrayList<>();

        specialities.add(new Speciality(1, "Lose weight and get toned", 1));
        specialities.add(new Speciality(2, "Gain flexibility", 1));
        specialities.add(new Speciality(3, "Build muscle and boost stamina", 1));
        specialities.add(new Speciality(4, "Athletic event or competition", 1));
        specialities.add(new Speciality(5, "Other injuries or medical conditions", 1));

        return specialities;
    }
}
