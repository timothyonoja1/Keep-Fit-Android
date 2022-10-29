package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.Speciality;
import java.util.List;

public interface SpecialityLocalDataSource {

    boolean isOutdated();

    boolean saveSpecialities(List<Speciality>specialities);

    List<Speciality> getAllLoggedInUserSpecialities();

    boolean deleteAllSpecialities();
}
