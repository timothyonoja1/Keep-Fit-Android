package com.kratos.keepfit.di;

import com.kratos.keepfit.localdatasources.fakes.FakeAgeRangeLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeAllergyLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeFitnessCategoryLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeFitnessGoalLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeFitnessProgrammeFitnessGoalLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeFitnessProgrammeLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeFitnessProgrammeSkillLevelLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeFitnessVideoLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeGalleryLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeHeightRangeLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeScheduleLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeSkillLevelLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeSpecialityLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeUserAllergyLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeUserFitnessGoalLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeWeeklyTrainingDurationLocalDataSource;
import com.kratos.keepfit.localdatasources.fakes.FakeWeightRangeLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.AgeRangeLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.AllergyLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.FitnessCategoryLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.FitnessGoalLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.FitnessProgrammeFitnessGoalLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.FitnessProgrammeLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.FitnessProgrammeSkillLevelLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.FitnessVideoLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.GalleryLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.HeightRangeLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.ScheduleLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.SkillLevelLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.SpecialityLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.UserAllergyLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.UserFitnessGoalLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.WeeklyTrainingDurationLocalDataSource;
import com.kratos.keepfit.localdatasources.interfaces.WeightRangeLocalDataSource;

import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class LocalDataSourceModule {

    @Binds
    @Singleton
    public abstract AgeRangeLocalDataSource bindAgeRangeLocalDataSource(
            FakeAgeRangeLocalDataSource ageRangeLocalDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract AllergyLocalDataSource bindAllergyLocalDataSource(
            FakeAllergyLocalDataSource allergyLocalDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract FitnessCategoryLocalDataSource bindFitnessCategoryLocalDataSource (
            FakeFitnessCategoryLocalDataSource fitnessCategoryLocalDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract FitnessGoalLocalDataSource bindFitnessGoalLocalDataSource(
            FakeFitnessGoalLocalDataSource fitnessGoalLocalDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract FitnessProgrammeFitnessGoalLocalDataSource bindFitnessProgrammeFitnessGoalLocalDataSource(
            FakeFitnessProgrammeFitnessGoalLocalDataSource fitnessProgrammeFitnessGoalLocalDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract FitnessProgrammeLocalDataSource bindFitnessProgrammeLocalDataSource(
            FakeFitnessProgrammeLocalDataSource fitnessProgrammeLocalDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract FitnessProgrammeSkillLevelLocalDataSource bindFitnessProgrammeSkillLevelLocalDataSource(
            FakeFitnessProgrammeSkillLevelLocalDataSource fitnessProgrammeSkillLevelLocalDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract FitnessVideoLocalDataSource bindFitnessVideoLocalDataSource (
            FakeFitnessVideoLocalDataSource fitnessVideoLocalDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract GalleryLocalDataSource bindGalleryLocalDataSource (
            FakeGalleryLocalDataSource galleryLocalDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract HeightRangeLocalDataSource bindHeightRangeLocalDataSource (
            FakeHeightRangeLocalDataSource heightRangeLocalDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract ScheduleLocalDataSource bindScheduleLocalDataSource (
            FakeScheduleLocalDataSource scheduleLocalDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract SkillLevelLocalDataSource bindSkillLevelLocalDataSource (
            FakeSkillLevelLocalDataSource skillLevelLocalDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract SpecialityLocalDataSource bindSpecialityLocalDataSource (
            FakeSpecialityLocalDataSource specialityLocalDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract UserAllergyLocalDataSource bindUserAllergyLocalDataSource(
            FakeUserAllergyLocalDataSource userAllergyLocalDataSourceImpl
    );


    @Binds
    @Singleton
    public abstract UserFitnessGoalLocalDataSource bindUserFitnessGoalLocalDataSource(
            FakeUserFitnessGoalLocalDataSource userFitnessGoalLocalDataSourceImpl
    );


    @Binds
    @Singleton
    public abstract WeeklyTrainingDurationLocalDataSource bindWeeklyTrainingDurationLocalDataSource(
            FakeWeeklyTrainingDurationLocalDataSource weeklyTrainingDurationLocalDataSourceImpl
    );

    @Binds
    @Singleton
    public abstract WeightRangeLocalDataSource bindWeightRangeLocalDataSource(
            FakeWeightRangeLocalDataSource weightRangeLocalDataSourceImpl
    );

}
