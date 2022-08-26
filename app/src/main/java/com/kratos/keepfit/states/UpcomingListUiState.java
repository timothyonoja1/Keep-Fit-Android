package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.Upcoming;
import java.util.List;

public class UpcomingListUiState {

    private final boolean fetchinhUpcomingList;
    private final List<Upcoming> upcomingList;

    public UpcomingListUiState(boolean fetchinhUpcomingList, List<Upcoming> upcomingList) {
        this.fetchinhUpcomingList = fetchinhUpcomingList;
        this.upcomingList = upcomingList;
    }

    public boolean isFetchinhUpcomingList() {
        return fetchinhUpcomingList;
    }

    public List<Upcoming> getUpcomingList() {
        return upcomingList;
    }
}