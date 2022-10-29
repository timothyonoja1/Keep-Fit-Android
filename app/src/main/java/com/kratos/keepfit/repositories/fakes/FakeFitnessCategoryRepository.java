package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.core.ResultCallback;
import com.kratos.keepfit.entities.FitnessCategory;
import com.kratos.keepfit.repositories.interfaces.FitnessCategoryRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessCategoryRepository implements FitnessCategoryRepository {

    @Inject
    public FakeFitnessCategoryRepository() {

    }

    @Override
    public void getAllFitnessCategories(ResultCallback<List<FitnessCategory>> callback) {
        callback.onComplete(getAllFitnessCategoriesSync());
    }

    @Override
    public List<FitnessCategory> getAllFitnessCategoriesSync() {
        return getMockFitnessCategories();
    }

    @Override
    public List<Integer> getAllFitnessCategoryIDsSync() {
        List<Integer> result = new ArrayList<>();
        for (FitnessCategory fitnessCategory : getAllFitnessCategoriesSync()){
            result.add(fitnessCategory.getFitnessCategoryID());
        }
        return result;
    }

    private List<FitnessCategory> getMockFitnessCategories() {
        List<FitnessCategory> fitnessCategories = new ArrayList<>();
        fitnessCategories.add(new FitnessCategory(1, "Circuit Training"));

        return fitnessCategories;
    }
}
