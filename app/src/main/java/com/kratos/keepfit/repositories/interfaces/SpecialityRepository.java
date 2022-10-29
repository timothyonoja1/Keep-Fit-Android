package com.kratos.keepfit.repositories.interfaces;

import com.kratos.keepfit.entities.Speciality;

import java.util.List;

public interface SpecialityRepository {

    List<Speciality> getLoggedInUserSpecialities();

}
