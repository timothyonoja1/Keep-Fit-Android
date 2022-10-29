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
import com.kratos.keepfit.databinding.FragmentMainBinding;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
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
            NavDirections action = MainFragmentDirections
                    .actionMainFragmentToStepsFragment();
            Navigation.findNavController(textView).navigate(action);
        });

        binding.signupButton.setOnClickListener(buttonView -> {
            NavDirections action = MainFragmentDirections
                    .actionMainFragmentToRegisterFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });
        binding.accessNowButton.setOnClickListener(buttonView -> {
            NavDirections action = MainFragmentDirections
                    .actionMainFragmentToRegisterFragment();
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