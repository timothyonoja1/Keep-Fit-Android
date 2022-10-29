package com.kratos.keepfit.datastores.fakes;

import com.kratos.keepfit.datastores.interfaces.SkillLevelDataStore;
import com.kratos.keepfit.entities.SkillLevel;

import javax.inject.Inject;

public class FakeSkillLevelDataStore implements SkillLevelDataStore {

    private SkillLevel skillLevel;

    @Inject
    public FakeSkillLevelDataStore() {

    }

    @Override
    public boolean saveSkillLevelSelectedByUser(SkillLevel skillLevel) {
        return false;
    }

    @Override
    public SkillLevel getSkillLevelSelectedByUser() {
        return skillLevel;
    }

    @Override
    public boolean deleteSkillLevelSelectedByUser() {
        return false;
    }
}
