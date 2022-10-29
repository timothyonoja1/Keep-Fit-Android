package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.HeightRange;
import com.kratos.keepfit.remotedatasources.interfaces.HeightRangeRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeHeightRangeRemoteDataSource implements HeightRangeRemoteDataSource {

    @Inject
    public FakeHeightRangeRemoteDataSource() {

    }

    @Override
    public List<HeightRange> getAllHeightRanges() {
        return new ArrayList<>();
    }
}