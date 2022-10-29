package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.FitnessCategory;
import java.util.List;

public interface FitnessCategoryLocalDataSource {

    boolean isOutdated();

    List<FitnessCategory> getAllFitnessCategories();

    boolean saveFitnessCategories(List<FitnessCategory> fitnessCategories);

}
