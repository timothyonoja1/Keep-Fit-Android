package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.kratos.keepfit.databinding.FragmentNutritionalPlansBinding;

import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class NutritionalPlansFragment extends Fragment {

    private FragmentNutritionalPlansBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNutritionalPlansBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return view;
    }
}
