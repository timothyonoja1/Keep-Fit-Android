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
import com.kratos.keepfit.databinding.FragmentEnterNameBinding;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class EnterNameFragment extends Fragment {

    private FragmentEnterNameBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEnterNameBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.nextButton.setOnClickListener(buttonView -> {
            NavDirections action = EnterNameFragmentDirections
                    .actionEnterNameFragmentToEnterDetailsFragment();
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
