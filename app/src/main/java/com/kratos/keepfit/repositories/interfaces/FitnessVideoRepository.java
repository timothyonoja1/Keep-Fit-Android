package com.kratos.keepfit.repositories.interfaces;

import com.kratos.keepfit.core.ResultCallback;
import com.kratos.keepfit.entities.FitnessVideo;
import java.util.List;

public interface FitnessVideoRepository {

    void getFitnessVideos(int fitnessProgrammeID, ResultCallback<List<FitnessVideo>> callback);

    List<FitnessVideo> getFitnessVideosSync(int fitnessProgrammeID);

}