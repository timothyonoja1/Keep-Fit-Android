package com.kratos.keepfit.viewmodels.real;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kratos.keepfit.entities.Gallery;
import com.kratos.keepfit.entities.Schedule;
import com.kratos.keepfit.entities.Speciality;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;
import com.kratos.keepfit.repositories.interfaces.GalleryRepository;
import com.kratos.keepfit.repositories.interfaces.ScheduleRepository;
import com.kratos.keepfit.repositories.interfaces.SpecialityRepository;
import com.kratos.keepfit.repositories.interfaces.UserRepository;
import com.kratos.keepfit.states.AccountUiState;
import com.kratos.keepfit.viewmodels.interfaces.AccountViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AccountViewModelImpl extends ViewModel implements AccountViewModel {

    private final UserRepository userRepository;
    private final SpecialityRepository specialityRepository;
    private final GalleryRepository galleryRepository;
    private final ScheduleRepository scheduleRepository;
    private final Executor executor;
    private final MutableLiveData<AccountUiState> accountUiState;

    @Inject
    public AccountViewModelImpl(UserRepository userRepository,
                                SpecialityRepository specialityRepository,
                                GalleryRepository galleryRepository,
                                ScheduleRepository scheduleRepository,
                                Executor executor) {
        this.userRepository = userRepository;
        this.specialityRepository = specialityRepository;
        this.galleryRepository = galleryRepository;
        this.scheduleRepository = scheduleRepository;
        this.executor = executor;
        accountUiState = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<AccountUiState> getAccountUiState() {
        accountUiState.setValue(new AccountUiState(
                true, null, null, new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>()));
        executor.execute(() -> {
            UserProfile userProfile = userRepository.getLoggedInUserProfileSync();
            UserProfileDetail userProfileDetail = userRepository.getLoggedInUserProfileDetailSync();
            List<Speciality> specialities = specialityRepository.getLoggedInUserSpecialities();
            List<Gallery> galleries = galleryRepository.getLoggedInUserGalleries();
            List<Schedule> schedules = scheduleRepository.getLoggedInUserSchedules();
            accountUiState.postValue(new AccountUiState(
                    false, userProfile, userProfileDetail, specialities,
                    galleries, schedules));
        });
        return accountUiState;
    }
}
