package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.UserAllergy;
import com.kratos.keepfit.remotedatasources.interfaces.UserAllergyRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeUserAllergyRemoteDataSource implements UserAllergyRemoteDataSource {

    private final List<UserAllergy> userAllergies = new ArrayList<>();

    @Inject
    public FakeUserAllergyRemoteDataSource() {

    }

    @Override
    public boolean postUserAllergies(List<Integer> allergyIDs, int userProfileID) {
        userAllergies.clear();
        int userAllergyID = 1;
        for (int allergyID : allergyIDs) {
            userAllergies.add(new UserAllergy(userAllergyID, userProfileID, allergyID));
        }

        return true;
    }
}
