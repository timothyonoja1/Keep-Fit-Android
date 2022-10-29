package com.kratos.keepfit.di;

import com.kratos.keepfit.remotedatasources.retrofit.ApiService;
import com.kratos.keepfit.remotedatasources.retrofit.AuthenticationService;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/** Injects interfaces needed for making api calls. */
@Module
@InstallIn(SingletonComponent.class)
public class ApiModule {

    private static final String BASE_URL = "https://keepfit-api.azurewebsites.net/";

    /** Injects Retrofit interface. */
    @Provides
    @Singleton
    public static ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    /** Injects Retrofit interface. */
    @Provides
    @Singleton
    public static AuthenticationService provideAuthenticationService(Retrofit retrofit){
        return retrofit.create(AuthenticationService.class);
    }

    /** Injects Retrofit interface. */
    @Provides
    @Singleton
    public static Retrofit provideRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /** Injects OkHttpClient interface. */
    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor){
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    /** Injects HttpLoggingInterceptor interface. */
    @Provides
    @Singleton
    public static HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}