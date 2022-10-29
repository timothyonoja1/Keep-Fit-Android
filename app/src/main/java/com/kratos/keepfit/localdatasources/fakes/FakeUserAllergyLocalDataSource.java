package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.localdatasources.interfaces.UserAllergyLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeUserAllergyLocalDataSource implements UserAllergyLocalDataSource {

    private final List<Integer> allergyIDs = new ArrayList<>();

    @Inject
    public FakeUserAllergyLocalDataSource() {

    }

    @Override
    public boolean saveUserAllergy(List<Integer> allergyIDs) {
        this.allergyIDs.clear();
        this.allergyIDs.addAll(allergyIDs);
        return true;
    }

    @Override
    public List<Integer> getAllergyIDs() {
        return allergyIDs;
    }
}