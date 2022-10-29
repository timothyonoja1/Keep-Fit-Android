package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.FitnessProgrammeSkillLevel;
import com.kratos.keepfit.localdatasources.interfaces.FitnessProgrammeSkillLevelLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessProgrammeSkillLevelLocalDataSource
        implements FitnessProgrammeSkillLevelLocalDataSource {

    private final List<FitnessProgrammeSkillLevel> fitnessProgrammeSkillLevels = new ArrayList<>();

    @Inject
    public FakeFitnessProgrammeSkillLevelLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return true;
    }

    @Override
    public boolean saveFitnessProgrammeSkillLevels(List<FitnessProgrammeSkillLevel> fitnessProgrammeSkillLevels) {
        this.fitnessProgrammeSkillLevels.clear();
        this.fitnessProgrammeSkillLevels.addAll(fitnessProgrammeSkillLevels);
        return true;
    }

    @Override
    public List<Integer> getFitnessProgrammeIDs(List<Integer> skillLevelIDs) {
        List<Integer> result = new ArrayList<>();
        for (int skillLevelID : skillLevelIDs) {
            result.addAll(getFitnessProgrammeIDs(skillLevelID));
        }
        return result;
    }

    private List<Integer> getFitnessProgrammeIDs(int skillLevelID) {
        List<Integer> result = new ArrayList<>();
        for (FitnessProgrammeSkillLevel fitnessProgrammeSkillLevel : fitnessProgrammeSkillLevels) {
            if (fitnessProgrammeSkillLevel.getSkillLevelID() == skillLevelID) {
                result.add(fitnessProgrammeSkillLevel.getFitnessProgrammeID());
            }
        }
        return result;
    }
}
