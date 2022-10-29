package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.Allergy;
import com.kratos.keepfit.localdatasources.interfaces.AllergyLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeAllergyLocalDataSource implements AllergyLocalDataSource {

    private final List<Allergy> allergies = new ArrayList<>();

    @Inject
    public FakeAllergyLocalDataSource(){

    }
    @Override
    public boolean isOutdated() {
        return true;
    }

    @Override
    public List<Allergy> getAllAllergies() {
        return allergies;
    }

    @Override
    public boolean saveAllergies(List<Allergy> allergies) {
        this.allergies.clear();
        this.allergies.addAll(allergies);
        return true;
    }
}
