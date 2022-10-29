package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.repositories.interfaces.UserAllergyRepository;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeUserAllergyRepository implements UserAllergyRepository {

    private final List<Integer> allergyIDs = new ArrayList<>();

    @Inject
    public FakeUserAllergyRepository(){

    }

    @Override
    public boolean saveUserAllergy(List<Integer> allergyIDs) {
        this.allergyIDs.clear();
        this.allergyIDs.addAll(allergyIDs);
        return true;
    }

    @Override
    public boolean sendSavedUserAllergiesToBackend() {
        return true;
    }

}
