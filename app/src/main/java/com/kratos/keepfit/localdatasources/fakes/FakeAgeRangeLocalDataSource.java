package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.AgeRange;
import com.kratos.keepfit.localdatasources.interfaces.AgeRangeLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeAgeRangeLocalDataSource implements AgeRangeLocalDataSource {

    private final List<AgeRange> ageRanges = new ArrayList<>();

    @Inject
    public  FakeAgeRangeLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return true;
    }

    @Override
    public boolean saveAgeRanges(List<AgeRange> ageRanges) {
        this.ageRanges.clear();
        this.ageRanges.addAll(ageRanges);
        return true;
    }

    @Override
    public List<AgeRange> getAllAgeRanges() {
        return ageRanges;
    }
}
