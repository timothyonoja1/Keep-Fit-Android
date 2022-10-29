package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.FitnessCategory;
import com.kratos.keepfit.localdatasources.interfaces.FitnessCategoryLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessCategoryLocalDataSource implements FitnessCategoryLocalDataSource {

    private final List<FitnessCategory> fitnessCategories = new ArrayList<>();

    @Inject
    public FakeFitnessCategoryLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return true;
    }

    @Override
    public List<FitnessCategory> getAllFitnessCategories() {
        return fitnessCategories;
    }

    @Override
    public boolean saveFitnessCategories(List<FitnessCategory> fitnessCategories) {
        this.fitnessCategories.clear();
        this.fitnessCategories.addAll(fitnessCategories);
        return true;
    }
}
