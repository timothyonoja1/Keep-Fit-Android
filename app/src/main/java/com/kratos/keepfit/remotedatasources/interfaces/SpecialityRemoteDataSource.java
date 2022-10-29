package com.kratos.keepfit.remotedatasources.interfaces;

import com.kratos.keepfit.entities.Speciality;
import java.util.List;

public interface SpecialityRemoteDataSource {

    List<Speciality> getSpecialities(int userProfileID);

}
