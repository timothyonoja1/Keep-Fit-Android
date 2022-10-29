package com.kratos.keepfit.repositories.interfaces;

import java.util.List;

public interface UserAllergyRepository {

    boolean saveUserAllergy(List<Integer> allergyIDs);

    boolean sendSavedUserAllergiesToBackend();

}
