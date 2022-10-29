package com.kratos.keepfit.viewmodels.fakes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kratos.keepfit.entities.Gender;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;
import com.kratos.keepfit.entities.UserRole;
import com.kratos.keepfit.states.HomeUiState;
import com.kratos.keepfit.viewmodels.interfaces.HomeViewModel;
import java.util.Date;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class FakeHomeViewModel extends ViewModel implements HomeViewModel {

    private final MutableLiveData<HomeUiState> homeUiState = new MutableLiveData<>();

    @Inject
    public FakeHomeViewModel() {

    }

    @Override
    public MutableLiveData<HomeUiState> getHomeUiState() {
        homeUiState.setValue(new HomeUiState("Good Morning", false, getMockUserProfile(),
                getMockUserProfileDetail(), "Fitness Programmes \n (15)"
        ));
        return homeUiState;
    }

    private UserProfile getMockUserProfile() {
        return new UserProfile(1, "example@gmail.com", "Daniel",
                "", new Date(), UserRole.Basic);
    }

    private UserProfileDetail getMockUserProfileDetail() {
        return new UserProfileDetail(1, 25, Gender.Male, 280,
                80, "I love God", "Ondo City", "dp_image.jpg",
                "https://www.facebook.com/dp_image.jpg", 0, false, 0, 1, 1,
                1, 1, 1, 1);
    }
}