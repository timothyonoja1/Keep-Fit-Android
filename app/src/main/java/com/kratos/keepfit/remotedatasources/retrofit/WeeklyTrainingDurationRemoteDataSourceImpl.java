package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import com.kratos.keepfit.remotedatasources.interfaces.WeeklyTrainingDurationRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class WeeklyTrainingDurationRemoteDataSourceImpl
        implements WeeklyTrainingDurationRemoteDataSource {

    private final ApiService apiService;

    @Inject
    public WeeklyTrainingDurationRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<WeeklyTrainingDuration> getAllWeeklyTrainingDurations() {
        Call<List<WeeklyTrainingDuration>> apiCall = apiService.getAllWeeklyTrainingDurations();
        try {
            return apiCall.execute().body();
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}