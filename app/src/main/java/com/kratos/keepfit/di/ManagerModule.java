package com.kratos.keepfit.di;

import com.kratos.keepfit.managers.interfaces.AllergyManager;
import com.kratos.keepfit.managers.interfaces.FitnessGoalManager;
import com.kratos.keepfit.managers.interfaces.FitnessProgrammeManager;
import com.kratos.keepfit.managers.real.AllergyManagerImpl;
import com.kratos.keepfit.managers.real.FitnessGoalManagerImpl;
import com.kratos.keepfit.managers.real.FitnessProgrammeManagerImpl;
import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class ManagerModule {

    @Binds
    @Singleton
    public abstract AllergyManager bindAllergyManager(
            AllergyManagerImpl allergyManagerImpl
    );

    @Binds
    @Singleton
    public abstract FitnessGoalManager bindFitnessGoalManager(
            FitnessGoalManagerImpl fitnessGoalManagerImpl
    );

    @Binds
    @Singleton
    public abstract FitnessProgrammeManager bindFitnessProgrammeManager(
            FitnessProgrammeManagerImpl fitnessProgrammeManagerImpl
    );

}