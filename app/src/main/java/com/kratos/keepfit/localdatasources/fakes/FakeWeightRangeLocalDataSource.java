package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.WeightRange;
import com.kratos.keepfit.localdatasources.interfaces.WeightRangeLocalDataSource;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeWeightRangeLocalDataSource implements WeightRangeLocalDataSource {

    private final List<WeightRange> weightRanges = new ArrayList<>();

    @Inject
    public FakeWeightRangeLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return true;
    }

    @Override
    public boolean saveWeightRanges(List<WeightRange> weightRanges) {
        this.weightRanges.clear();
        this.weightRanges.addAll(weightRanges);
        return true;
    }

    @Override
    public List<WeightRange> getAllWeightRanges() {
        return weightRanges;
    }
}
