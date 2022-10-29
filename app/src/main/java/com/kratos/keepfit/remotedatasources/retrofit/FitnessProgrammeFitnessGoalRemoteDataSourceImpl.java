package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.FitnessProgrammeFitnessGoal;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessProgrammeFitnessGoalRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class FitnessProgrammeFitnessGoalRemoteDataSourceImpl
        implements FitnessProgrammeFitnessGoalRemoteDataSource {

    private final ApiService apiService;

    @Inject
    public FitnessProgrammeFitnessGoalRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<FitnessProgrammeFitnessGoal> getAllFitnessProgrammeFitnessGoals() {
        Call<List<FitnessProgrammeFitnessGoal>> apiCall
                = apiService.getAllFitnessProgrammeFitnessGoals();
        try {
            return apiCall.execute().body();
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}
