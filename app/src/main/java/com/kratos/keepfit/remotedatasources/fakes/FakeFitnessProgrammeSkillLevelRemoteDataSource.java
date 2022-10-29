package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.FitnessProgrammeSkillLevel;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessProgrammeSkillLevelRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessProgrammeSkillLevelRemoteDataSource implements FitnessProgrammeSkillLevelRemoteDataSource {

    @Inject
    public FakeFitnessProgrammeSkillLevelRemoteDataSource() {

    }

    @Override
    public List<FitnessProgrammeSkillLevel> getAllFitnessProgrammeSkillLevels() {
        return new ArrayList<>();
    }
}
