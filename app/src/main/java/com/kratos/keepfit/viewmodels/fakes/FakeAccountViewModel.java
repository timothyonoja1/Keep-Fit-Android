package com.kratos.keepfit.viewmodels.fakes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kratos.keepfit.entities.Gallery;
import com.kratos.keepfit.entities.Gender;
import com.kratos.keepfit.entities.Schedule;
import com.kratos.keepfit.entities.Speciality;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;
import com.kratos.keepfit.entities.UserRole;
import com.kratos.keepfit.states.AccountUiState;
import com.kratos.keepfit.viewmodels.interfaces.AccountViewModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class FakeAccountViewModel extends ViewModel implements AccountViewModel {

    @Inject
    public FakeAccountViewModel() {

    }

    @Override
    public MutableLiveData<AccountUiState> getAccountUiState() {
        MutableLiveData<AccountUiState> accountUiState = new MutableLiveData<>();
        accountUiState.setValue(new AccountUiState(
            false, getMockUserProfile(), getMockUserProfileDetail(), getMockSpecialities(),
            getMockGalleries(), getMockSchedules()
        ));
        return accountUiState;
    }

    private UserProfile getMockUserProfile() {
        return new UserProfile(1, "example@gmail.com", "Daniel",
                "", new Date(), UserRole.Basic);
    }

    private UserProfileDetail getMockUserProfileDetail() {
        return new UserProfileDetail(
                1, 25, Gender.Male, 280, 80,
                "I love God", "Ondo City", "dp_image.jpg",
                "https://www.facebook.com/dp_image.jpg", 0, false, 0, 1, 1,
                1, 1, 1,
                1
        );
    }

    private List<Speciality> getMockSpecialities() {
        List<Speciality> specialities = new ArrayList<>();

        specialities.add(new Speciality(1, "Lose weight and get toned", 1));
        specialities.add(new Speciality(2, "Gain flexibility", 1));
        specialities.add(new Speciality(3, "Build muscle and boost stamina", 1));
        specialities.add(new Speciality(4, "Athletic event or competition", 1));
        specialities.add(new Speciality(5, "Other injuries or medical conditions", 1));

        return specialities;
    }

    private List<Gallery> getMockGalleries() {
        List<Gallery> galleries = new ArrayList<>();

        galleries.add(new Gallery(1, "https://facebook.com/image.jpg", "", 1));
        galleries.add(new Gallery(1, "https://facebook.com/image.jpg", "",  1));
        galleries.add(new Gallery(1, "https://facebook.com/image.jpg", "",  1));

        return galleries;
    }

    private List<Schedule> getMockSchedules() {
        List<Schedule> schedules = new ArrayList<>();
        schedules.add(new Schedule(1, "07:30 AM", "Available"));
        schedules.add(new Schedule(2, "08:00 AM", "Available"));
        schedules.add(new Schedule(3, "08:00 AM", "Booked"));
        schedules.add(new Schedule(4, "08:30 AM", "Booked"));

        return schedules;
    }
}