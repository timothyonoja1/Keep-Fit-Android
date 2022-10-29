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
import com.kratos.keepfit.R;
import com.kratos.keepfit.adapters.GalleryAdapter;
import com.kratos.keepfit.adapters.ScheduleAdapter;
import com.kratos.keepfit.adapters.SpecialityAdapter;
import com.kratos.keepfit.databinding.FragmentAccountBinding;
import com.kratos.keepfit.states.AccountUiState;
import com.kratos.keepfit.viewmodels.interfaces.AccountViewModel;
import com.kratos.keepfit.viewmodels.real.AccountViewModelImpl;
import com.squareup.picasso.Picasso;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AccountFragment extends Fragment {

    private FragmentAccountBinding binding;
    private AccountViewModel accountViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAccountBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.userProfileImage.setOnClickListener(imageView -> {
            NavDirections action = AccountFragmentDirections
                    .actionAccountFragmentToProfileFragment();
            Navigation.findNavController(imageView).navigate(action);
        });
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
        accountViewModel = new ViewModelProvider(requireActivity()).get(AccountViewModelImpl.class);
        accountViewModel.getAccountUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingAccountUiState()) {

                    }
                    else {
                        updateUI(result);
                    }
                }
        );
    }

    private void updateUI(AccountUiState accountUiState) {
        Picasso.get().load(accountUiState.getUserProfileDetail().getImageUri())
                .placeholder(R.drawable.grey_background).error(R.drawable.grey_background)
                .into(binding.userProfileImage);

        binding.firstNameTextView.setText(accountUiState.getUserProfile().getFirstname());
        binding.yearsOfFitnessJourneyTextView.setText(
                String.format("Fitness . %s Year Journey",
                        accountUiState.getUserProfileDetail().getNumberOfSessions())
        );
        binding.numberOfSessionsTextView.setText(
                String.format("\t %s \n Sessions",
                        accountUiState.getUserProfileDetail().getNumberOfSessions())
        );

        boolean userAvailable = accountUiState.getUserProfileDetail().isAvailable();

        if (!userAvailable) {
            binding.isAvailableButton.setVisibility(View.GONE);
        }

        SpecialityAdapter specialityAdapter = new SpecialityAdapter(accountUiState.getSpecialities());
        binding.specialityListRecyclerView.setAdapter(specialityAdapter);
        if (accountUiState.getSpecialities().isEmpty()) {
            binding.noSpecialityTextView.setVisibility(View.VISIBLE);
        }

        GalleryAdapter galleryAdapter = new GalleryAdapter(accountUiState.getGalleries());
        binding.galleryListRecyclerView.setAdapter(galleryAdapter);
        if (accountUiState.getGalleries().isEmpty()) {
            binding.noGalleryTextView.setVisibility(View.VISIBLE);
        }

        String userDescription = accountUiState.getUserProfileDetail().getDescription();
        if (userDescription == null) {
            binding.noDescriptionTextView.setVisibility(View.VISIBLE);
        }
        else {
            binding.descriptionTextView.setText(userDescription);
        }

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(accountUiState.getSchedules());
        binding.scheduleListRecyclerView.setAdapter(scheduleAdapter);
        if (accountUiState.getSchedules().isEmpty()) {
            binding.noScheduleTextView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}