package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.core.ResultCallback;
import com.kratos.keepfit.entities.FitnessVideo;
import com.kratos.keepfit.repositories.interfaces.FitnessVideoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessVideoRepository implements FitnessVideoRepository {

    private final List<FitnessVideo> fitnessVideos = getMockFitnessVideoList();

    @Inject
    public FakeFitnessVideoRepository() {

    }

    @Override
    public void getFitnessVideos(int fitnessProgrammeID,
                                 ResultCallback<List<FitnessVideo>> callback) {
        callback.onComplete(getFitnessVideosSync(fitnessProgrammeID));
    }

    @Override
    public List<FitnessVideo> getFitnessVideosSync(int fitnessProgrammeID) {
        List<FitnessVideo> result = new ArrayList<>();
        for (FitnessVideo fitnessVideo : fitnessVideos) {
            if (fitnessVideo.getFitnessProgrammeID() == fitnessProgrammeID) {
                result.add(fitnessVideo);
            }
        }
        return result;
    }

    private List<FitnessVideo> getMockFitnessVideoList() {
        List<FitnessVideo> fitnessVideoList = new ArrayList<>();
        fitnessVideoList.add(new FitnessVideo(
                1, 1, "@drawable/banded_lateral_walk",
                "", "Banded Lateral Walk", "0.30 seconds Body. Building", false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                2, 1, "@drawable/bicycle_crunch",
                "", "Bicycle Crunch", "0.30 seconds. Body Building", true, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                3, 1, "@drawable/donkey_kicks",
                "", "Donkey Kicks", "0.48 mi away. Body Building", false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                4, 1, "@drawable/in_and_out_jump",
                "", "In and Out", "0.31 mi away. Body Building", false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                5, 1, "@drawable/kneeling_push_ups",
                "", "Kneeling push up", "1.23 mi away. Body Building", true, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                6, 1, "@drawable/lunges",
                "", "Lunges", "0.48 mi away. Body Building", false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                7, 2, "@drawable/burpees",
                "", "Burpees", "0.30 seconds. Body Building", false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                8, 2, "@drawable/feet_together_skip",
                "", "Fit together Skip", "0.30 seconds. Body Building", true, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                9, 3, "@drawable/body_weight_squats",
                "", "Body Weight Squats", "0.30 seconds. Body Building", false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                10, 3, "@drawable/elbow_plank",
                "", "Elbow Plank", "0.30 seconds. Body Building", true, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                11, 3, "@drawable/foot_plank_bench",
                "", "1 Foot Plank + Bench/Chair", "0.40 mi away. Body Building", false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                12, 3, "@drawable/foot_plank",
                "", "Elbow Plank", "0.31 mi away. Body Building", false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                13, 3, "@drawable/push_ups",
                "", "Push ups", "0.23 mi away. Body Building", true, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                14, 4, "@drawable/chest_press",
                "", "Chest Press, Inc Weights", "0.30 seconds. Body Building", false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                15, 4, "@drawable/chest_press",
                "", "Chest Press, Inc Weights", "0.30 seconds. Body Building", true, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                16, 4, "@drawable/barbell_squats",
                "", "Barbell Squats", "0.48 mi away. Body Building", false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                16, 4, "@drawable/sumo_deadlifts",
                "", "Sumo Deadlifts", "0.31 mi away. Body Building", false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                16, 4, "@drawable/swiss_ball",
                "", "Swiss Ball Barbell Chest Press", "123 mi away. Body Building", false, 5, 30));

        return fitnessVideoList;
    }

}
