package com.kratos.keepfit.di;

import com.kratos.keepfit.utilities.interfaces.ValidationUtility;
import com.kratos.keepfit.utilities.real.ValidationUtilityImpl;
import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects utility interfaces. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class UtilityModule {

    /** Injects DateTimeUtility implementation with given parameter. */
    @Binds
    @Singleton
    public abstract ValidationUtility bindValidationUtility(
            ValidationUtilityImpl validationUtilityImpl
    );

}