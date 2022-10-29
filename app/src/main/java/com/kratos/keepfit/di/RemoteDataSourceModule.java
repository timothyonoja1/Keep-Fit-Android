package com.kratos.keepfit.di;

import com.kratos.keepfit.remotedatasources.fakes.FakeAgeRangeRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeAllergyRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeFitnessCategoryRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeFitnessGoalRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeFitnessProgrammeFitnessGoalRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeFitnessProgrammeRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeFitnessProgrammeSkillLevelRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeFitnessVideoRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeGalleryRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeHeightRangeRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeScheduleRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeSkillLevelRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeSpecialityRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeUserAllergyRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeUserFitnessGoalRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeUserRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeWeeklyTrainingDurationRemoteDataSource;
import com.kratos.keepfit.remotedatasources.fakes.FakeWeightRangeRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.AgeRangeRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.AllergyRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessCategoryRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessGoalRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessProgrammeFitnessGoalRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessProgrammeRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessProgrammeSkillLevelRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessVideoRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.GalleryRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.HeightRangeRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.ScheduleRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.SkillLevelRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.SpecialityRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.UserAllergyRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.UserFitnessGoalRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.UserRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.WeeklyTrainingDurationRemoteDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.WeightRangeRemoteDataSource;
import com.kratos.keepfit.remotedatasources.retrofit.FitnessCategoryRemoteDataSourceImpl;

import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects remote data sources interfaces. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    public abstract AgeRangeRemoteDataSource bindAgeRangeRemoteDataSource(
            FakeAgeRangeRemoteDataSource ageRangeRemoteDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract AllergyRemoteDataSource bindAllergyRemoteDataSource(
            FakeAllergyRemoteDataSource allergyRemoteDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract FitnessCategoryRemoteDataSource bindFitnessCategoryRemoteDataSource(
            FitnessCategoryRemoteDataSourceImpl fitnessCategoryRemoteDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract FitnessGoalRemoteDataSource bindFitnessGoalRemoteDataSource(
            FakeFitnessGoalRemoteDataSource fitnessGoalRemoteDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract FitnessProgrammeFitnessGoalRemoteDataSource bindFitnessProgrammeFitnessGoalRemoteDataSource(
            FakeFitnessProgrammeFitnessGoalRemoteDataSource fitnessProgrammeFitnessGoalRemoteDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract FitnessProgrammeRemoteDataSource bindFitnessProgrammeRemoteDataSource(
            FakeFitnessProgrammeRemoteDataSource fitnessProgrammeRemoteDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract FitnessProgrammeSkillLevelRemoteDataSource bindFitnessProgrammeSkillLevelRemoteDataSource(
            FakeFitnessProgrammeSkillLevelRemoteDataSource fitnessProgrammeSkillLevelRemoteDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract FitnessVideoRemoteDataSource bindFitnessVideoRemoteDataSource(
            FakeFitnessVideoRemoteDataSource fitnessVideoRemoteDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract GalleryRemoteDataSource bindGalleryRemoteDataSource(
            FakeGalleryRemoteDataSource galleryRemoteDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract HeightRangeRemoteDataSource bindHeightRangeRemoteDataSource(
            FakeHeightRangeRemoteDataSource heightRangeRemoteDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract ScheduleRemoteDataSource bindScheduleRemoteDataSource(
            FakeScheduleRemoteDataSource galleryRemoteDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract SkillLevelRemoteDataSource bindSkillLevelRemoteDataSource(
            FakeSkillLevelRemoteDataSource skillLevelRemoteDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract SpecialityRemoteDataSource bindSpecialityRemoteDataSource(
            FakeSpecialityRemoteDataSource specialityRemoteDataSourceImpl
    );

    /** Injects UserRemoteDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract UserRemoteDataSource bindUserRemoteDataSource(
            FakeUserRemoteDataSource userRemoteDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract UserAllergyRemoteDataSource bindUserAllergyRemoteDataSource(
            FakeUserAllergyRemoteDataSource userAllergyRemoteDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract UserFitnessGoalRemoteDataSource bindUserFitnessGoalRemoteDataSource(
            FakeUserFitnessGoalRemoteDataSource userFitnessGoalRemoteDataSourceImpl
    );


    @Binds
    @Singleton
    public abstract WeeklyTrainingDurationRemoteDataSource bindWeeklyTrainingDurationRemoteDataSource(
            FakeWeeklyTrainingDurationRemoteDataSource weeklyTrainingDurationRemoteDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract WeightRangeRemoteDataSource bindWeightRangeRemoteDataSource(
            FakeWeightRangeRemoteDataSource weightRangeRemoteDataSourceImpl
    );

}