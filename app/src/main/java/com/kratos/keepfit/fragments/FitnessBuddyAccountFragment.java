package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kratos.keepfit.R;
import com.kratos.keepfit.adapters.GalleryAdapter;
import com.kratos.keepfit.adapters.ScheduleAdapter;
import com.kratos.keepfit.adapters.SpecialityAdapter;
import com.kratos.keepfit.databinding.FragmentFitnessBuddyAccountBinding;
import com.kratos.keepfit.states.FitnessBuddyAccountUiState;
import com.kratos.keepfit.viewmodels.fakes.FakeFitnessBuddyViewModel;
import com.kratos.keepfit.viewmodels.interfaces.FitnessBuddyViewModel;
import com.squareup.picasso.Picasso;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FitnessBuddyAccountFragment extends Fragment {

    private FragmentFitnessBuddyAccountBinding binding;
    private FitnessBuddyViewModel fitnessBuddyViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFitnessBuddyAccountBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.specialityListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        binding.galleryListRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        binding.scheduleListRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fitnessBuddyViewModel = new ViewModelProvider(requireActivity()).get(FakeFitnessBuddyViewModel.class);
        fitnessBuddyViewModel.getFitnessBuddyAccountUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingAccountUiState()) {

                    }
                    else {
                        updateUI(result);
                    }
                }
        );
    }

    private void updateUI(FitnessBuddyAccountUiState fitnessBuddyAccountUiState) {
        Picasso.get().load(fitnessBuddyAccountUiState.getUserProfileDetail().getImageUri())
                .placeholder(R.drawable.grey_background).error(R.drawable.grey_background)
                .into(binding.userProfileImage);

        binding.firstNameTextView.setText(fitnessBuddyAccountUiState.getUserProfile().getFirstname());
        binding.yearsOfFitnessJourneyTextView.setText(
                String.format("Fitness . %s Year Journey",
                        fitnessBuddyAccountUiState.getUserProfileDetail().getNumberOfSessions())
        );
        binding.numberOfSessionsTextView.setText(
                String.format("\t %s \n Sessions",
                        fitnessBuddyAccountUiState.getUserProfileDetail().getNumberOfSessions())
        );

        boolean userAvailable = fitnessBuddyAccountUiState.getUserProfileDetail().isAvailable();

        if (!userAvailable) {
            binding.isAvailableButton.setVisibility(View.GONE);
        }

        SpecialityAdapter specialityAdapter = new SpecialityAdapter(fitnessBuddyAccountUiState.getSpecialities());
        binding.specialityListRecyclerView.setAdapter(specialityAdapter);


        GalleryAdapter galleryAdapter = new GalleryAdapter(fitnessBuddyAccountUiState.getGalleries());
        binding.galleryListRecyclerView.setAdapter(galleryAdapter);

        String userDescription = fitnessBuddyAccountUiState.getUserProfileDetail().getDescription();
        binding.descriptionTextView.setText(userDescription);

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(fitnessBuddyAccountUiState.getSchedules());
        binding.scheduleListRecyclerView.setAdapter(scheduleAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
