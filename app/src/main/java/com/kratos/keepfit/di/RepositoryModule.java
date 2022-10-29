package com.kratos.keepfit.di;

import com.kratos.keepfit.repositories.fakes.FakeFitnessProgrammeSkillLevelRepository;
import com.kratos.keepfit.repositories.interfaces.AgeRangeRepository;
import com.kratos.keepfit.repositories.interfaces.AllergyRepository;
import com.kratos.keepfit.repositories.interfaces.FitnessCategoryRepository;
import com.kratos.keepfit.repositories.interfaces.FitnessGoalRepository;
import com.kratos.keepfit.repositories.interfaces.FitnessProgrammeFitnessGoalRepository;
import com.kratos.keepfit.repositories.interfaces.FitnessProgrammeRepository;
import com.kratos.keepfit.repositories.interfaces.FitnessProgrammeSkillLevelRepository;
import com.kratos.keepfit.repositories.interfaces.FitnessVideoRepository;
import com.kratos.keepfit.repositories.interfaces.GalleryRepository;
import com.kratos.keepfit.repositories.interfaces.HeightRangeRepository;
import com.kratos.keepfit.repositories.interfaces.ScheduleRepository;
import com.kratos.keepfit.repositories.interfaces.SearchAndMatchRepository;
import com.kratos.keepfit.repositories.interfaces.SkillLevelRepository;
import com.kratos.keepfit.repositories.interfaces.SpecialityRepository;
import com.kratos.keepfit.repositories.interfaces.UserAllergyRepository;
import com.kratos.keepfit.repositories.interfaces.UserFitnessGoalRepository;
import com.kratos.keepfit.repositories.interfaces.UserRepository;
import com.kratos.keepfit.repositories.interfaces.WeeklyTrainingDurationRepository;
import com.kratos.keepfit.repositories.interfaces.WeightRangeRepository;
import com.kratos.keepfit.repositories.real.AgeRangeRepositoryImpl;
import com.kratos.keepfit.repositories.real.AllergyRepositoryImpl;
import com.kratos.keepfit.repositories.real.FitnessCategoryRepositoryImpl;
import com.kratos.keepfit.repositories.real.FitnessGoalRepositoryImpl;
import com.kratos.keepfit.repositories.real.FitnessProgrammeFitnessGoalRepositoryImpl;
import com.kratos.keepfit.repositories.real.FitnessProgrammeRepositoryImpl;
import com.kratos.keepfit.repositories.real.FitnessVideoRepositoryImpl;
import com.kratos.keepfit.repositories.real.GalleryRepositoryImpl;
import com.kratos.keepfit.repositories.real.HeightRangeRepositoryImpl;
import com.kratos.keepfit.repositories.real.ScheduleRepositoryImpl;
import com.kratos.keepfit.repositories.real.SearchAndMatchRepositoryImpl;
import com.kratos.keepfit.repositories.real.SkillLevelRepositoryImpl;
import com.kratos.keepfit.repositories.real.SpecialityRepositoryImpl;
import com.kratos.keepfit.repositories.real.UserAllergyRepositoryImpl;
import com.kratos.keepfit.repositories.real.UserFitnessGoalRepositoryImpl;
import com.kratos.keepfit.repositories.real.UserRepositoryImpl;
import com.kratos.keepfit.repositories.real.WeeklyTrainingDurationRepositoryImpl;
import com.kratos.keepfit.repositories.real.WeightRangeRepositoryImpl;

import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;


/** Injects repository interfaces. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class RepositoryModule {

    @Binds
    @Singleton
    public abstract AgeRangeRepository bindAgeRangeRepository(
            AgeRangeRepositoryImpl ageRangeRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract AllergyRepository bindAllergyRepository(
            AllergyRepositoryImpl allergyRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract FitnessCategoryRepository bindFitnessCategoryRepository(
            FitnessCategoryRepositoryImpl fitnessCategoryRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract FitnessGoalRepository bindFitnessGoalRepository(
            FitnessGoalRepositoryImpl fitnessGoalRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract FitnessProgrammeFitnessGoalRepository bindFitnessProgrammeFitnessGoalRepository(
            FitnessProgrammeFitnessGoalRepositoryImpl fitnessProgrammeFitnessGoalRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract FitnessProgrammeRepository bindFitnessProgrammeRepository(
            FitnessProgrammeRepositoryImpl fitnessProgrammeRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract FitnessProgrammeSkillLevelRepository bindFitnessProgrammeSkillLevelRepository(
            FakeFitnessProgrammeSkillLevelRepository fitnessProgrammeSkillLevelRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract FitnessVideoRepository bindFitnessVideoRepository(
            FitnessVideoRepositoryImpl fitnessVideoRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract GalleryRepository bindGalleryRepository(
            GalleryRepositoryImpl galleryRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract HeightRangeRepository bindHeightRangeRepository(
            HeightRangeRepositoryImpl heightRangeRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract ScheduleRepository bindScheduleRepository(
            ScheduleRepositoryImpl scheduleRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract SearchAndMatchRepository bindSearchAndMatchRepository(
            SearchAndMatchRepositoryImpl searchAndMatchRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract SkillLevelRepository bindSkillLevelRepository(
            SkillLevelRepositoryImpl skillLevelRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract SpecialityRepository bindSpecialityRepository(
            SpecialityRepositoryImpl specialityRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract UserAllergyRepository bindUserAllergyRepository(
            UserAllergyRepositoryImpl userAllergyRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract UserFitnessGoalRepository bindUserFitnessGoalRepository(
            UserFitnessGoalRepositoryImpl userFitnessGoalRepositoryImpl
    );

    /** Injects UserRepository implementation with given parameter. */
    @Binds
    @Singleton
    public abstract UserRepository bindUserRepository(
            UserRepositoryImpl userRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract WeeklyTrainingDurationRepository bindWeeklyTrainingDurationRepository(
            WeeklyTrainingDurationRepositoryImpl weeklyTrainingDurationRepositoryImpl
    );

    @Binds
    @Singleton
    public abstract WeightRangeRepository bindWeightRangeRepository(
            WeightRangeRepositoryImpl weightRangeRepositoryImpl
    );
}