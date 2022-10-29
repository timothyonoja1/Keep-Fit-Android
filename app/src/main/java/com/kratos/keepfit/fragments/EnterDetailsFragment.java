package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import com.kratos.keepfit.databinding.FragmentEnterDetailsBinding;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class EnterDetailsFragment extends Fragment {

    private FragmentEnterDetailsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEnterDetailsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.ageButton.setOnClickListener(buttonView -> {
            NavDirections action = EnterDetailsFragmentDirections
                    .actionEnterDetailsFragmentToAgeSelectionFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });

        binding.heightButton.setOnClickListener(buttonView -> {
            NavDirections action = EnterDetailsFragmentDirections
                    .actionEnterDetailsFragmentToHeightSelectionFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });

        binding.weightButton.setOnClickListener(buttonView -> {
            NavDirections action = EnterDetailsFragmentDirections
                    .actionEnterDetailsFragmentToWeightSelectionFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });

        binding.goalsButton.setOnClickListener(buttonView -> {
            NavDirections action = EnterDetailsFragmentDirections
                    .actionEnterDetailsFragmentToFitnessGoalSelectionFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });

        binding.levelButton.setOnClickListener(buttonView -> {
            NavDirections action = EnterDetailsFragmentDirections
                    .actionEnterDetailsFragmentToSkillLevelSelectionFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });

        binding.confirmDetailsButton.setOnClickListener(buttonView -> {
            NavDirections action = EnterDetailsFragmentDirections
                    .actionEnterDetailsFragmentToStepsFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
