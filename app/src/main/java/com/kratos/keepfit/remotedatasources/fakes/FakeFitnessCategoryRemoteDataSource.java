package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.FitnessCategory;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessCategoryRemoteDataSource;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessCategoryRemoteDataSource implements FitnessCategoryRemoteDataSource {

    @Inject
    public FakeFitnessCategoryRemoteDataSource() {

    }

    @Override
    public List<FitnessCategory> getAllFitnessCategories() {
        return getMockFitnessCategories();
    }

    private List<FitnessCategory> getMockFitnessCategories() {
        List<FitnessCategory> fitnessCategories = new ArrayList<>();
        fitnessCategories.add(new FitnessCategory(1, "Circuit Training"));

        return fitnessCategories;
    }
}
