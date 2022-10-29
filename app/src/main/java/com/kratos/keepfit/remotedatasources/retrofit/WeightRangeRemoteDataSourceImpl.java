package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.WeightRange;
import com.kratos.keepfit.remotedatasources.interfaces.WeightRangeRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class WeightRangeRemoteDataSourceImpl implements WeightRangeRemoteDataSource {

    private final ApiService apiService;

    @Inject
    public WeightRangeRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<WeightRange> getAllWeightRanges() {
        Call<List<WeightRange>> apiCall = apiService.getAllWeightRanges();
        try {
            return apiCall.execute().body();
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}