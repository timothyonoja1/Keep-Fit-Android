package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.UnrelatedFitnessBuddy;
import java.util.List;

public class FitnessBuddyUiState {

    private final boolean fetchingFitnessBuddyUiState;
    private final List<UnrelatedFitnessBuddy> unrelatedFitnessBuddies;
    private final List<UnrelatedFitnessBuddy> pendingAcceptances;

    public FitnessBuddyUiState(boolean fetchingFitnessBuddyUiState,
                               List<UnrelatedFitnessBuddy> unrelatedFitnessBuddies,
                               List<UnrelatedFitnessBuddy> pendingAcceptances) {
        this.fetchingFitnessBuddyUiState = fetchingFitnessBuddyUiState;
        this.unrelatedFitnessBuddies = unrelatedFitnessBuddies;
        this.pendingAcceptances = pendingAcceptances;
    }

    public boolean isFetchingFitnessBuddyUiState() {
        return fetchingFitnessBuddyUiState;
    }

    public List<UnrelatedFitnessBuddy> getUnrelatedFitnessBuddies() {
        return unrelatedFitnessBuddies;
    }

    public List<UnrelatedFitnessBuddy> getPendingAcceptances() {
        return pendingAcceptances;
    }
}