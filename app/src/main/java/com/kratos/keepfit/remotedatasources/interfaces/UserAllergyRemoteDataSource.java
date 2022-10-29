package com.kratos.keepfit.remotedatasources.interfaces;

import java.util.List;

public interface UserAllergyRemoteDataSource {

    boolean postUserAllergies(List<Integer> allergyIDs, int userProfileID);

}
