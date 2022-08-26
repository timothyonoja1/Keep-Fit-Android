package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.Upcoming;

public class UpcomingItemUiState {

    private final Upcoming selectedUpcomingItem;

    public UpcomingItemUiState(Upcoming selectedUpcomingItem) {
        this.selectedUpcomingItem = selectedUpcomingItem;
    }

    public Upcoming getSelectedUpcomingItem() {
        return selectedUpcomingItem;
    }
}