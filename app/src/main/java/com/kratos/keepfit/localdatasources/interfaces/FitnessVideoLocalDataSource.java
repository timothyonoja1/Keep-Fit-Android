package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.FitnessVideo;

import java.util.List;

public interface FitnessVideoLocalDataSource {

    boolean isOutdated(int fitnessProgrammeID);

    List<FitnessVideo> getFitnessVideos(int fitnessProgrammeID);

    boolean saveFitnessVideos(List<FitnessVideo> fitnessVideos);

}
