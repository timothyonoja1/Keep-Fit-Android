package com.kratos.keepfit.managers.real;

import com.kratos.keepfit.entities.Allergy;
import com.kratos.keepfit.managers.interfaces.AllergyManager;
import com.kratos.keepfit.repositories.interfaces.AllergyRepository;
import com.kratos.keepfit.repositories.interfaces.UserAllergyRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class AllergyManagerImpl implements AllergyManager {

    private final AllergyRepository allergyRepository;
    private final UserAllergyRepository userAllergyRepository;

    @Inject
    public AllergyManagerImpl(AllergyRepository allergyRepository,
                              UserAllergyRepository userAllergyRepository) {
        this.allergyRepository = allergyRepository;
        this.userAllergyRepository = userAllergyRepository;
    }

    @Override
    public List<Allergy> getAllAllergies() {
        return allergyRepository.getAllAllergies();
    }

    @Override
    public boolean saveUserAllergies(List<Allergy> allergies) {
        List<Integer> allergyIDs = new ArrayList<>();
        for (Allergy allergy : allergies) {
            allergyIDs.add(allergy.getAllergyID());
        }
        return userAllergyRepository.saveUserAllergy(allergyIDs);
    }
}
