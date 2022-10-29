package com.kratos.keepfit.datastores.interfaces;

import com.kratos.keepfit.entities.SkillLevel;

public interface SkillLevelDataStore {

    boolean saveSkillLevelSelectedByUser(SkillLevel skillLevel);

    SkillLevel getSkillLevelSelectedByUser();

    boolean deleteSkillLevelSelectedByUser();

}
