package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.AgeRange;
import com.kratos.keepfit.entities.Allergy;
import com.kratos.keepfit.entities.FitnessCategory;
import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.entities.FitnessProgramme;
import com.kratos.keepfit.entities.FitnessProgrammeFitnessGoal;
import com.kratos.keepfit.entities.FitnessProgrammeSkillLevel;
import com.kratos.keepfit.entities.FitnessVideo;
import com.kratos.keepfit.entities.Gallery;
import com.kratos.keepfit.entities.HeightRange;
import com.kratos.keepfit.entities.Schedule;
import com.kratos.keepfit.entities.SkillLevel;
import com.kratos.keepfit.entities.Speciality;
import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import com.kratos.keepfit.entities.WeightRange;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/** Retrofit interface for making api calls. */
public interface ApiService {

    @GET("api/AgeRanges")
    Call<List<AgeRange>> getAllAgeRanges();

    @GET("api/Allergies")
    Call<List<Allergy>> getAllAllergies();

    @GET("api/FitnessCategories")
    Call<List<FitnessCategory>> getAllFitnessCategories();

    @GET("api/FitnessGoals")
    Call<List<FitnessGoal>> getAllFitnessGoals();

    @GET("api/FitnessProgrammeFitnessGoals")
    Call<List<FitnessProgrammeFitnessGoal>> getAllFitnessProgrammeFitnessGoals();

    @GET("api/FitnessProgrammes")
    Call<List<FitnessProgramme>> getAllFitnessProgrammes();

    @GET("api/FitnessProgrammeSkillLevel")
    Call<List<FitnessProgrammeSkillLevel>> getAllFitnessProgrammeSkillLevels();

    @GET("api/FitnessVideos/{id}")
    Call<List<FitnessVideo>> getFitnessVideos(@Path("id") int fitnessProgrammeID);

    @GET("api/Galleries/{id}")
    Call<List<Gallery>> getGalleries(@Path("id") int userProfileID);

    @GET("api/HeightRanges")
    Call<List<HeightRange>> getAllHeightRanges();

    @GET("api/Schedules/{id}")
    Call<List<Schedule>> getSchedules(@Path("id") int userProfileID);

    @GET("api/SkillLevels")
    Call<List<SkillLevel>> getAllSkillLevels();

    @GET("api/Specialities/{id}")
    Call<List<Speciality>> getSpecialities(@Path("id") int userProfileID);

    @GET("api/WeeklyTrainingDurations")
    Call<List<WeeklyTrainingDuration>> getAllWeeklyTrainingDurations();

    @GET("api/WeightRanges")
    Call<List<WeightRange>> getAllWeightRanges();

}
