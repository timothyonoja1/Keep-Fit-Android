package com.kratos.keepfit.di;

import com.kratos.keepfit.repositories.interfaces.UserRepository;
import com.kratos.keepfit.repositories.real.UserRepositoryImpl;
import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects repository interfaces. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class RepositoryModule {

    /** Injects UserRepository implementation with given parameter. */
    @Binds
    @Singleton
    public abstract UserRepository bindUserRepository(
            UserRepositoryImpl userRepositoryImpl
    );

}
