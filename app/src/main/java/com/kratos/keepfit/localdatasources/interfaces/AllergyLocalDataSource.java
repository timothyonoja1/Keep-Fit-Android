package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.Allergy;
import java.util.List;

public interface AllergyLocalDataSource {

    boolean isOutdated();

    List<Allergy> getAllAllergies();

    boolean saveAllergies(List<Allergy> allergies);
}
