package com.kratos.keepfit.repositories.real;

import android.os.Handler;
import com.kratos.keepfit.core.ResultCallback;
import com.kratos.keepfit.entities.FitnessCategory;
import com.kratos.keepfit.localdatasources.interfaces.FitnessCategoryLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessCategoryRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.FitnessCategoryRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class FitnessCategoryRepositoryImpl implements FitnessCategoryRepository {

    private final FitnessCategoryLocalDataSource fitnessCategoryLocalDataSource;
    private final FitnessCategoryRemoteDataSource fitnessCategoryRemoteDataSource;
    private final Executor executor;
    private final Handler resultHandler;

    @Inject
    public FitnessCategoryRepositoryImpl(FitnessCategoryLocalDataSource fitnessCategoryLocalDataSource,
                                         FitnessCategoryRemoteDataSource fitnessCategoryRemoteDataSource,
                                         Executor executor, Handler resultHandler) {
        this.fitnessCategoryLocalDataSource = fitnessCategoryLocalDataSource;
        this.fitnessCategoryRemoteDataSource = fitnessCategoryRemoteDataSource;
        this.executor = executor;
        this.resultHandler = resultHandler;
    }

    @Override
    public void getAllFitnessCategories(ResultCallback<List<FitnessCategory>> callback) {
        executor.execute(() -> {
            List<FitnessCategory> result = getAllFitnessCategoriesSync();
            postResultToMainThread(result, callback);
        });
    }

    @Override
    public List<FitnessCategory> getAllFitnessCategoriesSync() {
        if (fitnessCategoryLocalDataSource.isOutdated()){
            refreshFitnessCategoryLocalDataSource();
        }
        return fitnessCategoryLocalDataSource.getAllFitnessCategories();
    }

    @Override
    public List<Integer> getAllFitnessCategoryIDsSync() {
        List<Integer> result = new ArrayList<>();
        for (FitnessCategory fitnessCategory : getAllFitnessCategoriesSync()){
            result.add(fitnessCategory.getFitnessCategoryID());
        }
        return result;
    }

    private void refreshFitnessCategoryLocalDataSource() {
        List<FitnessCategory> result = fitnessCategoryRemoteDataSource.getAllFitnessCategories();
        Date currentDate = new Date();
        for (FitnessCategory fitnessCategory : result) {
            fitnessCategory.setDateSavedToLocalDatabase(currentDate);
        }
        fitnessCategoryLocalDataSource.saveFitnessCategories(result);
    }

    private void postResultToMainThread(final List<FitnessCategory> result,
                                        final ResultCallback<List<FitnessCategory>> callback){
        resultHandler.post(() -> callback.onComplete(result));
    }
}
