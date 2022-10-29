package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.SkillLevel;
import java.util.List;

public interface SkillLevelLocalDataSource {

    boolean isOutdated();

    boolean saveSkillLevels(List<SkillLevel> skillLevels);

    List<SkillLevel> getAllSkillLevels();

}
