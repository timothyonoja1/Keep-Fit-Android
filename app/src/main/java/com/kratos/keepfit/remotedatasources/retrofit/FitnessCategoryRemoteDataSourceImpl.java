package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.FitnessCategory;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessCategoryRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class FitnessCategoryRemoteDataSourceImpl implements FitnessCategoryRemoteDataSource {

    private final ApiService apiService;

    @Inject
    public FitnessCategoryRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<FitnessCategory> getAllFitnessCategories() {
        Call<List<FitnessCategory>> apiCall = apiService.getAllFitnessCategories();
        try {
            return apiCall.execute().body();
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}
