package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.AgeRange;
import com.kratos.keepfit.entities.FitnessBuddyUserProfile;
import com.kratos.keepfit.remotedatasources.interfaces.AgeRangeRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeAgeRangeRemoteDataSource implements AgeRangeRemoteDataSource {

    @Inject
    public FakeAgeRangeRemoteDataSource() {

    }

    @Override
    public List<AgeRange> getAllAgeRanges() {
        return new ArrayList<>();
    }

}