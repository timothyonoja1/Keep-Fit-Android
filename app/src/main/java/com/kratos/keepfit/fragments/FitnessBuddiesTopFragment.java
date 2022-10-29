package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kratos.keepfit.adapters.FitnessBuddyAdapter;
import com.kratos.keepfit.adapters.PendingAcceptanceAdapter;
import com.kratos.keepfit.databinding.FragmentFitnessBuddiesTopBinding;
import com.kratos.keepfit.entities.UnrelatedFitnessBuddy;
import com.kratos.keepfit.viewmodels.fakes.FakeFitnessBuddyViewModel;
import com.kratos.keepfit.viewmodels.interfaces.FitnessBuddyViewModel;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class FitnessBuddiesTopFragment  extends Fragment {

    private FragmentFitnessBuddiesTopBinding binding;
    private FitnessBuddyViewModel fitnessBuddyViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFitnessBuddiesTopBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.fitnessBuddiesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.pendingAcceptanceRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fitnessBuddyViewModel = new ViewModelProvider(requireActivity()).get(FakeFitnessBuddyViewModel.class);
        fitnessBuddyViewModel.getFitnessBuddyUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingFitnessBuddyUiState()) {

                    }
                    else {

                        updateUI(result.getUnrelatedFitnessBuddies(), result.getPendingAcceptances());
                    }
                }
        );
    }

    private void updateUI(List<UnrelatedFitnessBuddy> unrelatedFitnessBuddyList,
                          List<UnrelatedFitnessBuddy> pendingAcceptances) {
        for (UnrelatedFitnessBuddy unrelatedFitnessBuddy : unrelatedFitnessBuddyList) {
            int imageResource = getResources().getIdentifier(unrelatedFitnessBuddy.getImageUrl(),
                    null, requireActivity().getPackageName());
            unrelatedFitnessBuddy.setDrawableResource(imageResource);
        }
        FitnessBuddyAdapter fitnessBuddyAdapter = new FitnessBuddyAdapter(
                unrelatedFitnessBuddyList, this::onClick, this::onClickAddIcon);
        binding.fitnessBuddiesRecyclerView.setAdapter(fitnessBuddyAdapter);

        PendingAcceptanceAdapter pendingAcceptanceAdapter
                = new PendingAcceptanceAdapter(pendingAcceptances, this::onClick);
        binding.pendingAcceptanceRecyclerView.setAdapter(pendingAcceptanceAdapter);
    }

    private void onClick(UnrelatedFitnessBuddy unrelatedFitnessBuddy) {
        fitnessBuddyViewModel.setSelectedFitnessBuddy(unrelatedFitnessBuddy.getFitnessBuddyID(),
                unrelatedFitnessBuddy.getUserProfileID());

        NavDirections action = FitnessBuddiesContainerFragmentDirections
                .actionFitnessBuddiesContainerFragmentToFitnessBuddyAccountFragment();
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }

    private void onClickAddIcon(UnrelatedFitnessBuddy unrelatedFitnessBuddy) {
        fitnessBuddyViewModel.addFitnessBuddy(unrelatedFitnessBuddy.getFitnessBuddyID());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}