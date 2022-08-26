package com.kratos.keepfit.di;

import com.kratos.keepfit.datastores.fakes.FakeUserDataStore;
import com.kratos.keepfit.datastores.interfaces.UserDataStore;
import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects data store interfaces. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class DataStoreModule {

    /** Injects User data store implementation with given parameter. */
    @Binds
    @Singleton
    public abstract UserDataStore bindUserDataStore(
            FakeUserDataStore userDataStoreImpl
    );

}