package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.HeightRange;
import com.kratos.keepfit.remotedatasources.interfaces.HeightRangeRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class HeightRangeRemoteDataSourceImpl implements HeightRangeRemoteDataSource {

    private final ApiService apiService;

    @Inject
    public HeightRangeRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<HeightRange> getAllHeightRanges() {
        Call<List<HeightRange>> apiCall = apiService.getAllHeightRanges();
        try {
            return apiCall.execute().body();
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}