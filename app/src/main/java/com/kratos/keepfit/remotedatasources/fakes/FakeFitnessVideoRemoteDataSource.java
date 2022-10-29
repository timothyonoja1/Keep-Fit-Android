package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.FitnessVideo;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessVideoRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessVideoRemoteDataSource implements FitnessVideoRemoteDataSource {

    private final List<FitnessVideo> fitnessVideos = getMockFitnessVideoList();

    @Inject
    public FakeFitnessVideoRemoteDataSource() {

    }

    @Override
    public List<FitnessVideo> getFitnessVideos(int fitnessProgrammeID) {
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
                "https://keepfitstorage.blob.core.windows.net/fitness-programme-container/1638023949306113398_d13a3f1d-68b8-4ca5-98be-adad1c5bb776.mp4",
                "Banded Lateral Walk", "0.30 seconds Body. Building",
                false, 5, 30)); 

        fitnessVideoList.add(new FitnessVideo(
                2, 1, "@drawable/bicycle_crunch",
                "https://keepfitstorage.blob.core.windows.net/fitness-programme-container/1638023957142151168_5989cfd0-ee8e-40c7-8906-1e24bc5b2309.mp4",
                "Bicycle Crunch", "0.30 seconds. Body Building",
                true, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                3, 1, "@drawable/donkey_kicks",
                "https://keepfitstorage.blob.core.windows.net/fitness-programme-container/1638023957826569610_f85ed77e-02ee-4be1-b2b3-5c2cf860e129.mp4",
                "Donkey Kicks", "0.48 mi away. Body Building",
                false, 5, 30));
        fitnessVideoList.add(new FitnessVideo(
                4, 1, "@drawable/in_and_out_jump",
                "https://keepfitstorage.blob.core.windows.net/fitness-programme-container/1638023960625608879_43bf79ac-bc81-426b-9c10-47024b371bdb.mov",
                "In and Out", "0.31 mi away. Body Building",
                false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                5, 1, "@drawable/kneeling_push_ups",
                "https://keepfitstorage.blob.core.windows.net/fitness-programme-container/1638023961896263271_271b5ba8-ded4-4e7c-b21f-bad44c461ac4.mov",
                "Kneeling push up", "1.23 mi away. Body Building",
                true, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                6, 1, "@drawable/lunges",
                "https://keepfitstorage.blob.core.windows.net/fitness-programme-container/1638023963393974860_34219f92-7777-40eb-8f51-37d0600679b8.mov",
                "Lunges", "0.48 mi away. Body Building",
                false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                7, 2, "@drawable/burpees",
                "https://keepfitstorage.blob.core.windows.net/fitness-programme-container/1637993249356516510_eb353955-5a65-4fc7-ac9f-4558f903d78d.mp4",
                "Burpees", "0.30 seconds. Body Building",
                false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                8, 2, "@drawable/feet_together_skip",
                "https://keepfitstorage.blob.core.windows.net/fitness-programme-container/1637993251067235833_f7ca3f47-d2c2-4b8e-b65c-6d11e6868a38.mov",
                "Feet together Skip", "0.30 seconds. Body Building",
                true, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                9, 3, "@drawable/body_weight_squats",
                "https://keepfitstorage.blob.core.windows.net/fitness-programme-container/1637993246798096176_d184d356-a8d4-49b1-854d-9ed04dc38c37.mp4",
                "Body Weight Squats", "0.30 seconds. Body Building",
                false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                10, 3, "@drawable/elbow_plank",
                "https://keepfitstorage.blob.core.windows.net/fitness-programme-container/1637993249719842495_977337d4-974b-40c1-b8cd-778516eec1ba.mp4",
                "Elbow Plank", "0.30 seconds. Body Building",
                true, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                11, 3, "@drawable/foot_plank_bench",
                "https://keepfitstorage.blob.core.windows.net/fitness-programme-container/1637993251690265229_a8c2adc5-90c3-48cf-be30-9d03a4ac2289.mp4",
                "1 Foot Plank + Bench/Chair", "0.40 mi away. Body Building",
                false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                12, 3, "@drawable/foot_plank",
                null, "Elbow Plank", "0.31 mi away. Body Building",
                false, 5, 30));

        fitnessVideoList.add(new FitnessVideo(
                13, 3, "@drawable/push_ups",
                "https://keepfitstorage.blob.core.windows.net/fitness-programme-container/1637993253093495482_060367f6-e1ad-4d9d-9969-d8740e6f4a23.mp4",
                "Push ups", "0.23 mi away. Body Building",
                true, 5, 30));


        return fitnessVideoList;
    }

}
