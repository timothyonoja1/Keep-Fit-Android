package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.Allergy;
import com.kratos.keepfit.remotedatasources.interfaces.AllergyRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class AllergyRemoteDataSourceImpl implements AllergyRemoteDataSource {

    private final ApiService apiService;

    @Inject
    public AllergyRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<Allergy> getAllAllergies() {
        Call<List<Allergy>> apiCall = apiService.getAllAllergies();
        try {
            return apiCall.execute().body();
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}