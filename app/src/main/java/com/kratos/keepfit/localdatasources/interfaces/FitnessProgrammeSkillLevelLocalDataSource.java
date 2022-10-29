package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.FitnessProgrammeSkillLevel;
import java.util.List;

public interface FitnessProgrammeSkillLevelLocalDataSource {

    boolean isOutdated();

    boolean saveFitnessProgrammeSkillLevels(
            List<FitnessProgrammeSkillLevel> fitnessProgrammeSkillLevels);

    List<Integer> getFitnessProgrammeIDs(List<Integer> skillLevelIDs);
}
