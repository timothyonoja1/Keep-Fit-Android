package com.kratos.keepfit.viewmodels.real;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kratos.keepfit.entities.Allergy;
import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import com.kratos.keepfit.managers.interfaces.AllergyManager;
import com.kratos.keepfit.managers.interfaces.FitnessGoalManager;
import com.kratos.keepfit.repositories.interfaces.UserRepository;
import com.kratos.keepfit.repositories.interfaces.WeeklyTrainingDurationRepository;
import com.kratos.keepfit.states.DetailsUiState;
import com.kratos.keepfit.states.DetailsUiStatus;
import com.kratos.keepfit.viewmodels.interfaces.DetailsViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DetailsViewModelImpl extends ViewModel implements DetailsViewModel {

    private final UserRepository userRepository;
    private final FitnessGoalManager fitnessGoalManager;
    private final AllergyManager allergyManager;
    private final WeeklyTrainingDurationRepository weeklyTrainingDurationRepository;
    private final Executor executor;
    private final MutableLiveData<DetailsUiState> detailsUiState;
    private final List<FitnessGoal> selectedFitnessGoals = new ArrayList<>();
    private final List<Allergy> selectedAllergies = new ArrayList<>();
    private int selectedWeeklyTrainingDurationID;

    @Inject
    public DetailsViewModelImpl(UserRepository userRepository, FitnessGoalManager fitnessGoalManager,
                                AllergyManager allergyManager,
                                WeeklyTrainingDurationRepository weeklyTrainingDurationRepository,
                                Executor executor) {
        this.userRepository = userRepository;
        this.fitnessGoalManager = fitnessGoalManager;
        this.allergyManager = allergyManager;
        this.weeklyTrainingDurationRepository = weeklyTrainingDurationRepository;
        this.executor = executor;
        detailsUiState = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<DetailsUiState> getDetailsUiState() {
        detailsUiState.postValue(new DetailsUiState(
                DetailsUiStatus.DetailsUiStateLoading, "", new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), false));
        executor.execute(() -> {
            detailsUiState.postValue(new DetailsUiState(
                    DetailsUiStatus.DetailsUiStateLoading, "", new ArrayList<>(),
                    new ArrayList<>(), new ArrayList<>(),
                    userRepository.hasActiveLoginTokenSync()));
            List<FitnessGoal> fitnessGoals = fitnessGoalManager.getALlFitnessGoals();
            List<Allergy> allergies = allergyManager.getAllAllergies();
            List<WeeklyTrainingDuration> weeklyTrainingDurations
                    = weeklyTrainingDurationRepository.getAllWeeklyTrainingDurations();
            if (fitnessGoals.isEmpty() || allergies.isEmpty() || weeklyTrainingDurations.isEmpty()){
                detailsUiState.postValue(new DetailsUiState(
                        DetailsUiStatus.DetailsUiStateLoadingFailure,
                        "Please check your internet connection",
                        fitnessGoals, weeklyTrainingDurations, allergies,
                        userRepository.hasActiveLoginTokenSync()));
            }
            else {
                detailsUiState.postValue(new DetailsUiState(
                        DetailsUiStatus.DetailsUiStateLoaded, "", fitnessGoals,
                        weeklyTrainingDurations, allergies,
                        userRepository.hasActiveLoginTokenSync()));
            }
        });
        return detailsUiState;
    }

    @Override
    public void onClick(FitnessGoal fitnessGoal) {
        for (FitnessGoal item : selectedFitnessGoals) {
            if (Objects.equals(item.getName(), fitnessGoal.getName())) {
                return;
            }
        }
        // If we get this far, fitness goal does not not exist in list
        selectedFitnessGoals.add(fitnessGoal);
    }

    @Override
    public void onClick(WeeklyTrainingDuration weeklyTrainingDuration) {
        selectedWeeklyTrainingDurationID = weeklyTrainingDuration.getWeeklyTrainingDurationID();
    }

    @Override
    public void onClick(Allergy allergy) {
        for (Allergy item : selectedAllergies) {
            if (Objects.equals(item.getName(), allergy.getName())){
                selectedAllergies.remove(item);
                return;
            }
        }
        // If we get this far, allergy does not not exist in list
        selectedAllergies.add(allergy);
    }

    @Override
    public void confirm() {
        executor.execute(() -> {
            if (selectedFitnessGoals.isEmpty() || selectedWeeklyTrainingDurationID == 0
                    || selectedAllergies.isEmpty()) {
                detailsUiState.postValue(new DetailsUiState(
                        DetailsUiStatus.InputError, "Please fill necessary details",
                        new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                        userRepository.hasActiveLoginTokenSync()));
                return;
            }
            boolean fitnessGoalSaveResult = fitnessGoalManager.saveUserFitnessGoals(selectedFitnessGoals);
            boolean allergySaveResult = allergyManager.saveUserAllergies(selectedAllergies);
            boolean weeklyTrainingDuration = weeklyTrainingDurationRepository
                    .saveWeeklyTrainingDurationIDofUser(selectedWeeklyTrainingDurationID);
            if (fitnessGoalSaveResult && allergySaveResult
                    && weeklyTrainingDuration) {
                detailsUiState.postValue(new DetailsUiState(
                        DetailsUiStatus.DetailsSubmissionSuccess, "",
                        new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                        userRepository.hasActiveLoginTokenSync()));
            }
            else {
                detailsUiState.postValue(new DetailsUiState(
                        DetailsUiStatus.DetailsSubmissionFailure, "",
                        new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                        userRepository.hasActiveLoginTokenSync()));
            }
        });
    }
}