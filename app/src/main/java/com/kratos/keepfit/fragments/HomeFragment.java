package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.kratos.keepfit.R;
import com.kratos.keepfit.databinding.FragmentHomeBinding;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

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
        binding.fitnessProgrammes.setOnClickListener(imageView -> {
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
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
