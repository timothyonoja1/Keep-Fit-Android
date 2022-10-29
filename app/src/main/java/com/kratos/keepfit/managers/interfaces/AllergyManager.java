package com.kratos.keepfit.managers.interfaces;

import com.kratos.keepfit.entities.Allergy;

import java.util.List;

public interface AllergyManager {

    List<Allergy> getAllAllergies();

    boolean saveUserAllergies(List<Allergy> allergies);

}
