package com.kratos.keepfit.repositories.interfaces;

import com.kratos.keepfit.core.ResultCallback;
import com.kratos.keepfit.entities.FitnessCategory;
import java.util.List;

public interface FitnessCategoryRepository {

    void getAllFitnessCategories(ResultCallback<List<FitnessCategory>> callback);

    List<FitnessCategory> getAllFitnessCategoriesSync();

    List<Integer> getAllFitnessCategoryIDsSync();

}