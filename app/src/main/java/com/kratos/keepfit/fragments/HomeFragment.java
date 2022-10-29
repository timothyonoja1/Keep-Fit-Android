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
import com.kratos.keepfit.R;
import com.kratos.keepfit.databinding.FragmentHomeBinding;
import com.kratos.keepfit.states.HomeUiState;
import com.kratos.keepfit.viewmodels.interfaces.HomeViewModel;
import com.kratos.keepfit.viewmodels.real.HomeViewModelImpl;
import com.squareup.picasso.Picasso;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.allButton.setOnClickListener(buttonView -> {
            binding.allButton.setBackgroundColor(getResources().getColor(R.color.dark_primary));
            binding.keepFitMatchesButton.setBackgroundColor(getResources().getColor(R.color.white));
        });
        binding.keepFitMatchesButton.setOnClickListener(buttonView -> {
            binding.keepFitMatchesButton.setBackgroundColor(getResources().getColor(R.color.dark_primary));
            binding.allButton.setBackgroundColor(getResources().getColor(R.color.light_grey));
        });
        binding.searchAndMatch.setOnClickListener(textView -> {
            NavDirections action = HomeFragmentDirections
                    .actionHomeFragmentToStepsFragment();
            Navigation.findNavController(textView).navigate(action);
        });
        binding.fitnessProgrammesTextView.setOnClickListener(imageView -> {
            NavDirections action = HomeFragmentDirections
                    .actionHomeFragmentToFitnessProgrammesFragment();
            Navigation.findNavController(imageView).navigate(action);
        });
        binding.fitnessBuddies.setOnClickListener(imageView -> {
            NavDirections action = HomeFragmentDirections
                    .actionHomeFragmentToFitnessBuddiesContainerFragment();
            Navigation.findNavController(imageView).navigate(action);
        });
        binding.nutritionalPlans.setOnClickListener(imageView -> {
            NavDirections action = HomeFragmentDirections
                    .actionHomeFragmentToNutritionalPlansFragment();
            Navigation.findNavController(imageView).navigate(action);
        });
        binding.liveFitness.setOnClickListener(imageView -> {
            NavDirections action = HomeFragmentDirections
                    .actionHomeFragmentToLiveFitnessFragment();
            Navigation.findNavController(imageView).navigate(action);
        });
        binding.groups.setOnClickListener(imageView -> {
            NavDirections action = HomeFragmentDirections
                    .actionHomeFragmentToGroupListFragment();
            Navigation.findNavController(imageView).navigate(action);
        });
        binding.trainingSpots.setOnClickListener(imageView -> {
            NavDirections action = HomeFragmentDirections
                    .actionHomeFragmentToSetLocationFragment();
            Navigation.findNavController(imageView).navigate(action);
        });
        binding.challenges.setOnClickListener(imageView -> {
            NavDirections action = HomeFragmentDirections
                    .actionHomeFragmentToChallengesFragment();
            Navigation.findNavController(imageView).navigate(action);
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModelImpl.class);
        homeViewModel.getHomeUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingUiState()) {

                    }
                    else {
                        updateUI(result);
                    }
                }
        );
    }

    private void updateUI(HomeUiState homeUiState) {
        binding.greetingTextView.setText(homeUiState.getAppropriateGreeting());
        binding.firstNameTextView.setText(homeUiState.getUserProfile().getFirstname());
        binding.numberOfSessionsTextView.setText(
                String.format("\t %s \n Sessions", homeUiState.getUserProfileDetail().getNumberOfSessions())
        );

        Picasso.get().load(homeUiState.getUserProfileDetail().getImageUri())
                .placeholder(R.drawable.grey_background).error(R.drawable.grey_background)
                .into(binding.profilePic);

        binding.fitnessProgrammesTextView.setText(homeUiState.getNumberOfFitnessProgrammes());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}