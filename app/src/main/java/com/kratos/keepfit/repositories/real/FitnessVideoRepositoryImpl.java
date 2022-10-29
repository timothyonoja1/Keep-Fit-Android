package com.kratos.keepfit.repositories.real;

import android.os.Handler;
import com.kratos.keepfit.core.ResultCallback;
import com.kratos.keepfit.entities.AgeRange;
import com.kratos.keepfit.entities.FitnessVideo;
import com.kratos.keepfit.localdatasources.interfaces.FitnessVideoLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessVideoRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.FitnessVideoRepository;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class FitnessVideoRepositoryImpl implements FitnessVideoRepository {

    private final FitnessVideoLocalDataSource fitnessVideoLocalDataSource;
    private final FitnessVideoRemoteDataSource fitnessVideoRemoteDataSource;
    private final Executor executor;
    private final Handler resultHandler;

    @Inject
    public FitnessVideoRepositoryImpl(FitnessVideoLocalDataSource fitnessVideoLocalDataSource,
                                      FitnessVideoRemoteDataSource fitnessVideoRemoteDataSource,
                                      Executor executor, Handler resultHandler) {
        this.fitnessVideoLocalDataSource = fitnessVideoLocalDataSource;

        this.fitnessVideoRemoteDataSource = fitnessVideoRemoteDataSource;
        this.executor = executor;
        this.resultHandler = resultHandler;
    }

    @Override
    public void getFitnessVideos(int fitnessProgrammeID, ResultCallback<List<FitnessVideo>> callback) {
        executor.execute(() -> {
            List<FitnessVideo> result = getFitnessVideosSync(fitnessProgrammeID);
            postResultToMainThread(result, callback);
        });
    }

    @Override
    public List<FitnessVideo> getFitnessVideosSync(int fitnessProgrammeID) {
        if (fitnessVideoLocalDataSource.isOutdated(fitnessProgrammeID)) {
            refreshFitnessVideoLocalDataSource(fitnessProgrammeID);
        }
        return fitnessVideoLocalDataSource.getFitnessVideos(fitnessProgrammeID);
    }

    private void refreshFitnessVideoLocalDataSource(int fitnessProgrammeID) {
        List<FitnessVideo> result = fitnessVideoRemoteDataSource.getFitnessVideos(fitnessProgrammeID);
        Date currentDate = new Date();
        for (FitnessVideo fitnessVideo : result) {
            fitnessVideo.setDateSavedToLocalDatabase(currentDate);
        }
        fitnessVideoLocalDataSource.saveFitnessVideos(result);
    }

    private void postResultToMainThread(final List<FitnessVideo> result,
                                        final ResultCallback<List<FitnessVideo>> callback){
        resultHandler.post(() -> callback.onComplete(result));
    }
}
