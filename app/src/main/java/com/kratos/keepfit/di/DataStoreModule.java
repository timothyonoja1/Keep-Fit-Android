package com.kratos.keepfit.di;

import com.kratos.keepfit.datastores.fakes.FakeAgeRangeDataStore;
import com.kratos.keepfit.datastores.fakes.FakeHeightRangeDataStore;
import com.kratos.keepfit.datastores.fakes.FakeSkillLevelDataStore;
import com.kratos.keepfit.datastores.fakes.FakeUserDataStore;
import com.kratos.keepfit.datastores.fakes.FakeWeeklyTrainingDurationDataStore;
import com.kratos.keepfit.datastores.fakes.FakeWeightRangeDataStore;
import com.kratos.keepfit.datastores.interfaces.AgeRangeDataStore;
import com.kratos.keepfit.datastores.interfaces.HeightRangeDataStore;
import com.kratos.keepfit.datastores.interfaces.SkillLevelDataStore;
import com.kratos.keepfit.datastores.interfaces.UserDataStore;
import com.kratos.keepfit.datastores.interfaces.WeeklyTrainingDurationDataStore;
import com.kratos.keepfit.datastores.interfaces.WeightRangeDataStore;
import com.kratos.keepfit.datastores.real.AgeRangeDataStoreImpl;
import com.kratos.keepfit.datastores.real.HeightRangeDataStoreImpl;
import com.kratos.keepfit.datastores.real.SkillLevelDataStoreImpl;
import com.kratos.keepfit.datastores.real.UserDataStoreImpl;
import com.kratos.keepfit.datastores.real.WeightRangeDataStoreImpl;

import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects data store interfaces. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class DataStoreModule {

    @Binds
    @Singleton
    public abstract AgeRangeDataStore bindAgeRangeDataStore(
            AgeRangeDataStoreImpl ageRangeDataStoreImpl
    );

    @Binds
    @Singleton
    public abstract HeightRangeDataStore bindHeightRangeDataStore(
            HeightRangeDataStoreImpl heightRangeDataStoreImpl
    );

    @Binds
    @Singleton
    public abstract SkillLevelDataStore bindSkillLevelDataStore(
            SkillLevelDataStoreImpl skillLevelDataStoreImpl
    );

    /** Injects User data store implementation with given parameter. */
    @Binds
    @Singleton
    public abstract UserDataStore bindUserDataStore(
            UserDataStoreImpl userDataStoreImpl
    );

    @Binds
    @Singleton
    public abstract WeeklyTrainingDurationDataStore bindWeeklyTrainingDurationDataStore(
            FakeWeeklyTrainingDurationDataStore weeklyTrainingDurationDataStoreImpl
    );

    @Binds
    @Singleton
    public abstract WeightRangeDataStore bindWeightRangeDataStore(
            WeightRangeDataStoreImpl weightRangeDataStoreImpl
    );

}