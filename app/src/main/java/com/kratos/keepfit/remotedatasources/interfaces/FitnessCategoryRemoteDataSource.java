package com.kratos.keepfit.remotedatasources.interfaces;

import com.kratos.keepfit.entities.FitnessCategory;
import java.util.List;

public interface FitnessCategoryRemoteDataSource {

    List<FitnessCategory> getAllFitnessCategories();

}
