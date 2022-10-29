package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.WeightRange;
import com.kratos.keepfit.remotedatasources.interfaces.WeightRangeRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeWeightRangeRemoteDataSource implements WeightRangeRemoteDataSource {

    @Inject
    public FakeWeightRangeRemoteDataSource() {

    }

    @Override
    public List<WeightRange> getAllWeightRanges() {
        return new ArrayList<>();
    }
}