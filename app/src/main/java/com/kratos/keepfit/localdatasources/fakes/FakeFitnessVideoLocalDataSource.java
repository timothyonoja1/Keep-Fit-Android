package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.FitnessVideo;
import com.kratos.keepfit.localdatasources.interfaces.FitnessVideoLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessVideoLocalDataSource implements FitnessVideoLocalDataSource {

    private List<FitnessVideo> fitnessVideos = new ArrayList<>();

    @Inject
    public FakeFitnessVideoLocalDataSource() {

    }

    @Override
    public boolean isOutdated(int fitnessProgrammeID) {
        return true;
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

    @Override
    public boolean saveFitnessVideos(List<FitnessVideo> fitnessVideos) {
        this.fitnessVideos.clear();
        this.fitnessVideos.addAll(fitnessVideos);
        return true;
    }
}
