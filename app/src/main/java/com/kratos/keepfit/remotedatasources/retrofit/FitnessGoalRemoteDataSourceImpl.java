package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessGoalRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class FitnessGoalRemoteDataSourceImpl implements FitnessGoalRemoteDataSource {

    private final ApiService apiService;

    @Inject
    public FitnessGoalRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<FitnessGoal> getAllFitnessGoals() {
        Call<List<FitnessGoal>> apiCall = apiService.getAllFitnessGoals();
        try {
            return apiCall.execute().body();
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}
