package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.SkillLevel;
import com.kratos.keepfit.remotedatasources.interfaces.SkillLevelRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class SkillLevelRemoteDataSourceImpl implements SkillLevelRemoteDataSource {

    private final ApiService apiService;

    @Inject
    public SkillLevelRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<SkillLevel> getAllSkillLevels() {
        Call<List<SkillLevel>> apiCall = apiService.getAllSkillLevels();
        try {
            return apiCall.execute().body();
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}