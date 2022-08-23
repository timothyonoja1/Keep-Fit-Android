package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayoutMediator;
import com.kratos.keepfit.adapters.FitnessBuddiesContainerAdapter;
import com.kratos.keepfit.databinding.FragmentFitnessBuddiesContainerBinding;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class FitnessBuddiesContainerFragment extends Fragment {

    private FragmentFitnessBuddiesContainerBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFitnessBuddiesContainerBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FitnessBuddiesContainerAdapter fitnessBuddiesContainerAdapter = new FitnessBuddiesContainerAdapter(this);
        binding.pager.setAdapter(fitnessBuddiesContainerAdapter);
        new TabLayoutMediator(binding.tabLayout, binding.pager, (tab, position) -> {
            if (position == 1){
                tab.setText("All");
            }
            else {
                tab.setText("Top");
            }
        }).attach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}