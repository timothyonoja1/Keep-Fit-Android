package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.entities.SkillLevel;
import com.kratos.keepfit.repositories.interfaces.SkillLevelRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeSkillLevelRepository implements SkillLevelRepository {

    private final List<SkillLevel> skillLevels;
    private SkillLevel skillLevelSelectedByUser;

    @Inject
    public FakeSkillLevelRepository() {
        skillLevels = new ArrayList<>();
    }

    @Override
    public boolean saveSkillLevelSelectedByUser(SkillLevel skillLevel) {
        skillLevelSelectedByUser = skillLevel;
        return true;
    }

    @Override
    public int getSkillLevelIDSelectedByUser() {
        if (skillLevelSelectedByUser == null) {
            return 0;
        }
        return skillLevelSelectedByUser.getSkillLevelID();
    }

    @Override
    public SkillLevel getSkillLevel(int skillLevelID) {
        for (SkillLevel skillLevel : skillLevels) {
            if (skillLevel.getSkillLevelID() == skillLevelID) {
                return skillLevel;
            }
        }
        return null;
    }

    @Override
    public List<SkillLevel> getAllSkillLevels() {
        return skillLevels;
    }

    @Override
    public boolean deleteSkillLevelSelectedByUser() {
        skillLevelSelectedByUser = null;
        return true;
    }
}
