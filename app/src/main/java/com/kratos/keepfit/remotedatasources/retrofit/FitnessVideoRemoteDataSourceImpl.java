package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.FitnessVideo;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessVideoRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class FitnessVideoRemoteDataSourceImpl implements FitnessVideoRemoteDataSource {

    private final ApiService apiService;

    @Inject
    public FitnessVideoRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<FitnessVideo> getFitnessVideos(int fitnessProgrammeID) {
        Call<List<FitnessVideo>> apiCall = apiService.getFitnessVideos(fitnessProgrammeID);
        try {
            return apiCall.execute().body();
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}