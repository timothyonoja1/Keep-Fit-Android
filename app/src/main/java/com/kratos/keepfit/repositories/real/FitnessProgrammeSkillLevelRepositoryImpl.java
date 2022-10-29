package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.entities.FitnessProgrammeSkillLevel;
import com.kratos.keepfit.localdatasources.interfaces.FitnessProgrammeSkillLevelLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessProgrammeSkillLevelRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.FitnessProgrammeSkillLevelRepository;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class FitnessProgrammeSkillLevelRepositoryImpl implements FitnessProgrammeSkillLevelRepository {

    private final FitnessProgrammeSkillLevelLocalDataSource fitnessProgrammeSkillLevelLocalDataSource;
    private final FitnessProgrammeSkillLevelRemoteDataSource fitnessProgrammeSkillLevelRemoteDataSource;

    @Inject
    public FitnessProgrammeSkillLevelRepositoryImpl(
            FitnessProgrammeSkillLevelLocalDataSource fitnessProgrammeSkillLevelLocalDataSource,
            FitnessProgrammeSkillLevelRemoteDataSource fitnessProgrammeSkillLevelRemoteDataSource) {
        this.fitnessProgrammeSkillLevelLocalDataSource = fitnessProgrammeSkillLevelLocalDataSource;
        this.fitnessProgrammeSkillLevelRemoteDataSource = fitnessProgrammeSkillLevelRemoteDataSource;
    }

    @Override
    public List<Integer> getFitnessProgrammeIDs(List<Integer> skillLevelIDs) {
        if (fitnessProgrammeSkillLevelLocalDataSource.isOutdated()) {
            refresh();
        }
        return fitnessProgrammeSkillLevelLocalDataSource.getFitnessProgrammeIDs(skillLevelIDs);
    }

    private void refresh() {
        List<FitnessProgrammeSkillLevel> result
                = fitnessProgrammeSkillLevelRemoteDataSource.getAllFitnessProgrammeSkillLevels();
        Date currentDate = new Date();
        for (FitnessProgrammeSkillLevel fitnessProgrammeSkillLevel : result) {
            fitnessProgrammeSkillLevel.setDateSavedToLocalDatabase(currentDate);
        }
        fitnessProgrammeSkillLevelLocalDataSource.saveFitnessProgrammeSkillLevels(result);
    }
}