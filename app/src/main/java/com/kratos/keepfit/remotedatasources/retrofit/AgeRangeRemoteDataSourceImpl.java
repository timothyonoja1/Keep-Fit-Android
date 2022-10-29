package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.AgeRange;
import com.kratos.keepfit.remotedatasources.interfaces.AgeRangeRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class AgeRangeRemoteDataSourceImpl implements AgeRangeRemoteDataSource {

    private final ApiService apiService;

    @Inject
    public AgeRangeRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<AgeRange> getAllAgeRanges() {
        Call<List<AgeRange>> apiCall = apiService.getAllAgeRanges();
        try {
            return apiCall.execute().body();
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}