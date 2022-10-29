package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.SkillLevel;
import com.kratos.keepfit.localdatasources.interfaces.SkillLevelLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeSkillLevelLocalDataSource implements SkillLevelLocalDataSource {

    private final List<SkillLevel> skillLevels = new ArrayList<>();

    @Inject
    public FakeSkillLevelLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return true;
    }

    @Override
    public boolean saveSkillLevels(List<SkillLevel> skillLevels) {
        this.skillLevels.clear();
        this.skillLevels.addAll(skillLevels);
        return true;
    }

    @Override
    public List<SkillLevel> getAllSkillLevels() {
        return skillLevels;
    }
}
