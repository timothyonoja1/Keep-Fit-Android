package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.Speciality;
import com.kratos.keepfit.remotedatasources.interfaces.SpecialityRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class SpecialityRemoteDataSourceImpl implements SpecialityRemoteDataSource {

    private final ApiService apiService;

    @Inject
    public SpecialityRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<Speciality> getSpecialities(int userProfileID) {
        Call<List<Speciality>> apiCall = apiService.getSpecialities(userProfileID);
        try {
            return apiCall.execute().body();
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}