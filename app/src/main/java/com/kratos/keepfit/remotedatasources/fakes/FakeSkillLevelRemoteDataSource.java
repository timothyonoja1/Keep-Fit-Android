package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.SkillLevel;
import com.kratos.keepfit.remotedatasources.interfaces.SkillLevelRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeSkillLevelRemoteDataSource implements SkillLevelRemoteDataSource {

    @Inject
    public FakeSkillLevelRemoteDataSource() {

    }

    @Override
    public List<SkillLevel> getAllSkillLevels() {
        return new ArrayList<>();
    }
}
