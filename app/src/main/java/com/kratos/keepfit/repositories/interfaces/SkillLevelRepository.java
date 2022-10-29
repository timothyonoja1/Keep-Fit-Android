package com.kratos.keepfit.repositories.interfaces;

import com.kratos.keepfit.entities.SkillLevel;
import java.util.List;

public interface SkillLevelRepository {

    boolean saveSkillLevelSelectedByUser(SkillLevel skillLevel);

    int getSkillLevelIDSelectedByUser();

    SkillLevel getSkillLevel(int skillLevelID);

    List<SkillLevel> getAllSkillLevels();

    boolean deleteSkillLevelSelectedByUser();

}
