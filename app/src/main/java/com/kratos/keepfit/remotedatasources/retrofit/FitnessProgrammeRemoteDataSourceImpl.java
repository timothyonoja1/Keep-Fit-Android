package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.FitnessProgramme;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessProgrammeRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class FitnessProgrammeRemoteDataSourceImpl implements FitnessProgrammeRemoteDataSource {

    private final ApiService apiService;

    @Inject
    public FitnessProgrammeRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<FitnessProgramme> getAllFitnessProgrammes() {
        Call<List<FitnessProgramme>> apiCall = apiService.getAllFitnessProgrammes();
        try {
            return apiCall.execute().body();
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}