package com.kratos.keepfit.viewmodels.real;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kratos.keepfit.repositories.interfaces.SkillLevelRepository;
import com.kratos.keepfit.repositories.interfaces.UserRepository;
import com.kratos.keepfit.states.ProfileUiState;
import com.kratos.keepfit.viewmodels.interfaces.ProfileViewModel;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ProfileViewModelImpl extends ViewModel implements ProfileViewModel {

    private final UserRepository userRepository;
    private final SkillLevelRepository skillLevelRepository;
    private final Executor executor;
    private final MutableLiveData<ProfileUiState> profileUiState;

    @Inject
    public ProfileViewModelImpl(UserRepository userRepository,
                                SkillLevelRepository skillLevelRepository,
                                Executor executor) {
        this.userRepository = userRepository;
        this.skillLevelRepository = skillLevelRepository;
        this.executor = executor;
        profileUiState = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<ProfileUiState> getProfileUiState() {
        profileUiState.setValue(new ProfileUiState(true, "",
                null, null, false
        ));
        executor.execute(() -> {
            profileUiState.postValue(new ProfileUiState(true, "",
                    null, null, false
            ));
            profileUiState.postValue(new ProfileUiState(false, "",
                    userRepository.getLoggedInUserProfileSync(),
                    userRepository.getLoggedInUserProfileDetailSync(), false
            ));
        });
        return profileUiState;
    }

    @Override
    public void logout() {

    }
}
