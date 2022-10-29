package com.kratos.keepfit.localdatasources.interfaces;

import java.util.List;

public interface UserAllergyLocalDataSource {

    boolean saveUserAllergy(List<Integer> allergyIDs);

    List<Integer> getAllergyIDs();

}
