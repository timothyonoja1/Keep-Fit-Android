package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.Gallery;
import com.kratos.keepfit.remotedatasources.interfaces.GalleryRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class GalleryRemoteDataSourceImpl implements GalleryRemoteDataSource {

    private final ApiService apiService;

    @Inject
    public GalleryRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<Gallery> getGalleries(int userProfileID) {
        Call<List<Gallery>> apiCall = apiService.getGalleries(userProfileID);
        try {
            return apiCall.execute().body();
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}