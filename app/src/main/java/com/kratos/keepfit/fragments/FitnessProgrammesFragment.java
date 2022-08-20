package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.kratos.keepfit.databinding.FragmentFitnessProgrammesBinding;
import dagger.hilt.android.AndroidEntryPoint;


/** Fragment for user log in. */
@AndroidEntryPoint
public class FitnessProgrammesFragment extends Fragment {

    private FragmentFitnessProgrammesBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFitnessProgrammesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
