package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.entities.Speciality;
import com.kratos.keepfit.repositories.interfaces.SpecialityRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeSpecialityRepository implements SpecialityRepository {

    private final List<Speciality> specialities;

    @Inject
    public FakeSpecialityRepository() {
        specialities = new ArrayList<>();
    }

    @Override
    public List<Speciality> getLoggedInUserSpecialities() {
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
