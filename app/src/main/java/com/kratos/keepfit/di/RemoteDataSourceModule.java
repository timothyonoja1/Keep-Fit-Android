package com.kratos.keepfit.di;

import com.kratos.keepfit.remotedatasources.fakes.FakeUserRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.UserRemoteDataSource;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects remote data sources interfaces. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class RemoteDataSourceModule {

    /** Injects UserRemoteDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract UserRemoteDataSource bindUserRemoteDataSource(
            FakeUserRemoteDataSource userRemoteDataSourceImpl
    );

}
