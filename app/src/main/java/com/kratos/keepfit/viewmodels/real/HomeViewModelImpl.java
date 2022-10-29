package com.kratos.keepfit.viewmodels.real;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.managers.interfaces.FitnessProgrammeManager;
import com.kratos.keepfit.repositories.interfaces.FitnessCategoryRepository;
import com.kratos.keepfit.repositories.interfaces.UserRepository;
import com.kratos.keepfit.states.HomeUiState;
import com.kratos.keepfit.utilities.interfaces.DateTimeUtility;
import com.kratos.keepfit.viewmodels.interfaces.HomeViewModel;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModelImpl extends ViewModel implements HomeViewModel {

    private final UserRepository userRepository;
    private final FitnessCategoryRepository fitnessCategoryRepository;
    private final FitnessProgrammeManager fitnessProgrammeManager;
    private final DateTimeUtility dateTimeUtility;
    private final Executor executor;
    public final MutableLiveData<HomeUiState> homeUiState;

    @Inject
    public HomeViewModelImpl(UserRepository userRepository,
                             FitnessCategoryRepository fitnessCategoryRepository,
                             FitnessProgrammeManager fitnessProgrammeManager,
                             DateTimeUtility dateTimeUtility, Executor executor) {
        this.userRepository = userRepository;
        this.fitnessCategoryRepository = fitnessCategoryRepository;
        this.fitnessProgrammeManager = fitnessProgrammeManager;
        this.dateTimeUtility = dateTimeUtility;
        this.executor = executor;
        homeUiState = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<HomeUiState> getHomeUiState() {
        homeUiState.setValue(new HomeUiState(
                dateTimeUtility.getAppropriateGreeting(), true, null,
                null, ""
        ));
        executor.execute(() -> {
            homeUiState.postValue(new HomeUiState(
                    dateTimeUtility.getAppropriateGreeting(), true, null,
                    null, ""
            ));
            List<Integer> fitnessCategoryIDs = fitnessCategoryRepository.getAllFitnessCategoryIDsSync();
            int numberOfFitnessProgrammes = fitnessProgrammeManager
                    .getNumberOfFitnessProgrammesSync(fitnessCategoryIDs);
            String numOfFitnessProgrammes = "Fitness Programmes \n (" + numberOfFitnessProgrammes + ")";
            homeUiState.postValue(new HomeUiState(
                    dateTimeUtility.getAppropriateGreeting(), false,
                    userRepository.getLoggedInUserProfileSync(),
                    userRepository.getLoggedInUserProfileDetailSync(), numOfFitnessProgrammes
            ));
        });
        return homeUiState;
    }

}
