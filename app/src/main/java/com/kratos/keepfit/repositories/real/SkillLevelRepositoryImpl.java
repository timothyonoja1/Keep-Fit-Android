package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.datastores.interfaces.SkillLevelDataStore;
import com.kratos.keepfit.entities.SkillLevel;
import com.kratos.keepfit.localdatasources.interfaces.SkillLevelLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.SkillLevelRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.SkillLevelRepository;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class SkillLevelRepositoryImpl implements SkillLevelRepository {

    private final SkillLevelDataStore skillLevelDataStore;
    private final SkillLevelLocalDataSource skillLevelLocalDataSource;
    private final SkillLevelRemoteDataSource skillLevelRemoteDataSource;

    @Inject
    public SkillLevelRepositoryImpl(SkillLevelDataStore skillLevelDataStore,
                                    SkillLevelLocalDataSource skillLevelLocalDataSource,
                                    SkillLevelRemoteDataSource skillLevelRemoteDataSource) {
        this.skillLevelDataStore = skillLevelDataStore;
        this.skillLevelLocalDataSource = skillLevelLocalDataSource;
        this.skillLevelRemoteDataSource = skillLevelRemoteDataSource;
    }

    @Override
    public boolean saveSkillLevelSelectedByUser(SkillLevel skillLevel) {
        skillLevelDataStore.saveSkillLevelSelectedByUser(skillLevel);
        return true;
    }

    @Override
    public int getSkillLevelIDSelectedByUser() {
        SkillLevel skillLevel = skillLevelDataStore.getSkillLevelSelectedByUser();
        if (skillLevel == null) {
            return 0;
        }
        return skillLevel.getSkillLevelID();
    }

    @Override
    public SkillLevel getSkillLevel(int skillLevelID) {
        List<SkillLevel> skillLevels = getAllSkillLevels();
        for (SkillLevel skillLevel : skillLevels) {
            if (skillLevel.getSkillLevelID() == skillLevelID) {
                return skillLevel;
            }
        }
        return null;
    }

    @Override
    public List<SkillLevel> getAllSkillLevels() {
        if (skillLevelLocalDataSource.isOutdated()) {
            refresh();
        }
        return skillLevelLocalDataSource.getAllSkillLevels();
    }

    @Override
    public boolean deleteSkillLevelSelectedByUser() {
        skillLevelDataStore.deleteSkillLevelSelectedByUser();
        return true;
    }

    private void refresh() {
        List<SkillLevel> result = skillLevelRemoteDataSource.getAllSkillLevels();
        Date currentDate = new Date();
        for (SkillLevel skillLevel : result) {
            skillLevel.setDateSavedToLocalDatabase(currentDate);
        }
        skillLevelLocalDataSource.saveSkillLevels(result);
    }
}
