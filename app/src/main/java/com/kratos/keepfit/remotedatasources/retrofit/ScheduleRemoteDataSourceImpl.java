package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.Schedule;
import com.kratos.keepfit.remotedatasources.interfaces.ScheduleRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class ScheduleRemoteDataSourceImpl implements ScheduleRemoteDataSource {

    private final ApiService apiService;

    @Inject
    public ScheduleRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<Schedule> getSchedules(int userProfileID) {
        Call<List<Schedule>> apiCall = apiService.getSchedules(userProfileID);
        try {
            return apiCall.execute().body();
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}