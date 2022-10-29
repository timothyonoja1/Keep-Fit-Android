package com.kratos.keepfit.managers.real;

import android.os.Handler;
import com.kratos.keepfit.core.ResultCallback;
import com.kratos.keepfit.entities.FitnessProgramme;
import com.kratos.keepfit.managers.interfaces.FitnessGoalManager;
import com.kratos.keepfit.managers.interfaces.FitnessProgrammeManager;
import com.kratos.keepfit.repositories.interfaces.FitnessProgrammeFitnessGoalRepository;
import com.kratos.keepfit.repositories.interfaces.FitnessProgrammeRepository;
import com.kratos.keepfit.repositories.interfaces.FitnessProgrammeSkillLevelRepository;
import com.kratos.keepfit.repositories.interfaces.SearchAndMatchRepository;
import com.kratos.keepfit.repositories.interfaces.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class FitnessProgrammeManagerImpl implements FitnessProgrammeManager {

    private final UserRepository userRepository;
    private final SearchAndMatchRepository searchAndMatchRepository;
    private final FitnessProgrammeRepository fitnessProgrammeRepository;
    private final FitnessProgrammeFitnessGoalRepository fitnessProgrammeFitnessGoalRepository;
    private final FitnessProgrammeSkillLevelRepository fitnessProgrammeSkillLevelRepository;
    private final FitnessGoalManager fitnessGoalManager;
    private final Executor executor;
    private final Handler resultHandler;

    @Inject
    public FitnessProgrammeManagerImpl(
            UserRepository userRepository, SearchAndMatchRepository searchAndMatchRepository,
            FitnessProgrammeRepository fitnessProgrammeRepository,
            FitnessProgrammeFitnessGoalRepository fitnessProgrammeFitnessGoalRepository,
            FitnessProgrammeSkillLevelRepository fitnessProgrammeSkillLevelRepository,
            FitnessGoalManager fitnessGoalManager, Executor executor, Handler resultHandler) {
        this.userRepository = userRepository;
        this.searchAndMatchRepository = searchAndMatchRepository;
        this.fitnessProgrammeRepository = fitnessProgrammeRepository;
        this.fitnessProgrammeFitnessGoalRepository = fitnessProgrammeFitnessGoalRepository;
        this.fitnessProgrammeSkillLevelRepository = fitnessProgrammeSkillLevelRepository;
        this.fitnessGoalManager = fitnessGoalManager;
        this.executor = executor;
        this.resultHandler = resultHandler;
    }

    @Override
    public int getNumberOfFitnessProgrammesSync(int fitnessCategoryID) {
        return getFitnessProgrammesSync(fitnessCategoryID).size();
    }

    @Override
    public void getFitnessProgrammes(int fitnessCategoryID, ResultCallback<List<FitnessProgramme>> callback) {
        executor.execute(() -> {
            List<FitnessProgramme> result = getFitnessProgrammesSync(fitnessCategoryID);
            postResultToMainThread(result, callback);
        });
    }

    @Override
    public int getNumberOfFitnessProgrammesSync(List<Integer> fitnessCategoryIDs) {
        int numberOfFitnessProgrammes = 0;
        for (int fitnessCategoryID : fitnessCategoryIDs) {
            numberOfFitnessProgrammes = numberOfFitnessProgrammes
                    + getNumberOfFitnessProgrammesSync(fitnessCategoryID);
        }
        return numberOfFitnessProgrammes;
    }

    @Override
    public List<FitnessProgramme> getFitnessProgrammesSync(int fitnessCategoryID) {
        List<Integer> fitnessProgrammeIDs = new ArrayList<>();

        fitnessProgrammeIDs.addAll(
                fitnessProgrammeFitnessGoalRepository.getFitnessProgrammeIDs(getFitnessGoalIDs()));
        fitnessProgrammeIDs.addAll(
                fitnessProgrammeSkillLevelRepository.getFitnessProgrammeIDs(getSkillLevelIDs()));

        return fitnessProgrammeRepository.getFitnessProgrammes(fitnessProgrammeIDs);
    }

    private List<Integer> getFitnessGoalIDs() {
        if (searchAndMatchRepository.getFitnessGoalIDs().isEmpty()) {
            fitnessGoalManager.getSavedFitnessGoalIDsOfLoggedInUser();
        }
        return searchAndMatchRepository.getFitnessGoalIDs();
    }

    private List<Integer> getSkillLevelIDs() {
        List<Integer> result = new ArrayList<>();
        if (searchAndMatchRepository.getSkillLevelID() == 0) {
            result.add(userRepository.getLoggedInUserProfileDetailSync().getSkillLevelID());
        }
        else {
            result.add(searchAndMatchRepository.getSkillLevelID());
        }
        return result;
    }

    private void postResultToMainThread(final List<FitnessProgramme> result,
                                        final ResultCallback<List<FitnessProgramme>> callback){
        resultHandler.post(() -> callback.onComplete(result));
    }
}
