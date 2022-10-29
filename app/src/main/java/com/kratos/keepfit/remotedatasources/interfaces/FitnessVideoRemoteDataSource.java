package com.kratos.keepfit.remotedatasources.interfaces;

import com.kratos.keepfit.entities.FitnessVideo;
import java.util.List;

public interface FitnessVideoRemoteDataSource {

    List<FitnessVideo> getFitnessVideos(int fitnessProgrammeID);

}
