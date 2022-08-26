package com.kratos.keepfit.viewmodels.fakes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kratos.keepfit.entities.Upcoming;
import com.kratos.keepfit.entities.UpcomingDetail;
import com.kratos.keepfit.states.UpcomingItemUiState;
import com.kratos.keepfit.states.UpcomingListUiState;
import com.kratos.keepfit.viewmodels.interfaces.UpcomingViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

/** Fake MainViewModel implementation class. */
@HiltViewModel
public class FakeUpcomingViewModel extends ViewModel implements UpcomingViewModel {

    private Upcoming selectedUpcomingItem;

    /** Constructs a new instance. */
    @Inject
    public FakeUpcomingViewModel() {

    }

    @Override
    public MutableLiveData<UpcomingListUiState> getUpcomingListUiState() {
        MutableLiveData<UpcomingListUiState> upcomingListUiState = new MutableLiveData<>();

        List<Upcoming> upcomingList = getMockUpcomingList();

        upcomingListUiState.setValue(new UpcomingListUiState(false, upcomingList));
        return upcomingListUiState;
    }

    @Override
    public MutableLiveData<UpcomingItemUiState> getUpcomingItemUiState() {
        MutableLiveData<UpcomingItemUiState> upcomingItemUiState = new MutableLiveData<>();
        upcomingItemUiState.setValue(new UpcomingItemUiState(selectedUpcomingItem));
        return upcomingItemUiState;
    }

    @Override
    public void setSelectedUpcomingItem(Upcoming upcomingItem) {
        selectedUpcomingItem = upcomingItem;
    }

    private List<Upcoming> getMockUpcomingList() {

        List<String> uris = new ArrayList<>();
        uris.add("@drawable/body_building_101");
        uris.add("@drawable/pilates");
        uris.add("@drawable/orthodox_training");
        uris.add("@drawable/stretch_exercises");
        uris.add("@drawable/journey");

        List<String> names = new ArrayList<>();
        names.add("Body building 101");
        names.add("Pilates");
        names.add("Orthodox training");
        names.add("Stretch Exercises");
        names.add("Journey");

        List<Upcoming> upcomingList = new ArrayList<>();
        Upcoming upcomingItem;
        UpcomingDetail upcomingDetail = null;

        int i = 0;
        while (i < 5) {
            if (i == 0) {
                upcomingDetail = new UpcomingDetail(
                        "23, Sep, 2021 | 10:00am", "Dwayne Johnson",
                        "Bring a mat, dumbbells up to 20kg and a bottle of water",
                        "Fat Burn, improved endurance",
                        "@drawable/dwayne_johnson",
                        "@drawable/quick_core_crush_background");
            }
            upcomingItem = new Upcoming(1, names.get(i),
                    "300", uris.get(i), upcomingDetail );
            upcomingList.add(upcomingItem);
            ++i;
            upcomingDetail = null;
        }

        return upcomingList;
    }
}