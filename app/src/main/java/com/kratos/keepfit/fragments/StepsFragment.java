package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import com.kratos.keepfit.databinding.FragmentStepsBinding;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class StepsFragment extends Fragment {

    private FragmentStepsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentStepsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.step1Button.setOnClickListener(buttonView -> {
            NavDirections action = StepsFragmentDirections
                    .actionStepsFragmentToEnterDetailsFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });

        binding.step2Button.setOnClickListener(buttonView -> {
            NavDirections action = StepsFragmentDirections
                    .actionStepsFragmentToDetailsFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
