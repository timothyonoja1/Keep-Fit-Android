package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.HeightRange;
import com.kratos.keepfit.localdatasources.interfaces.HeightRangeLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeHeightRangeLocalDataSource implements HeightRangeLocalDataSource {

    private final List<HeightRange> heightRanges = new ArrayList<>();

    @Inject
    public FakeHeightRangeLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return true;
    }

    @Override
    public boolean saveHeightRanges(List<HeightRange> heightRanges) {
        this.heightRanges.clear();
        this.heightRanges.addAll(heightRanges);
        return true;
    }

    @Override
    public List<HeightRange> getAllHeightRanges() {
        return heightRanges;
    }
}