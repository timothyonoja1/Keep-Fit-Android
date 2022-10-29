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
import com.kratos.keepfit.adapters.LiveFitnessAdapter;
import com.kratos.keepfit.entities.LiveFitness;
import com.kratos.keepfit.databinding.FragmentLiveFitnessBinding;
import com.kratos.keepfit.viewmodels.fakes.FakeLiveFitnessViewModel;
import com.kratos.keepfit.viewmodels.interfaces.LiveFitnessViewModel;

import java.util.ArrayList;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class LiveFitnessFragment extends Fragment {

    private FragmentLiveFitnessBinding binding;
    private LiveFitnessViewModel liveFitnessViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLiveFitnessBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.upcomingItemLayout.getRoot().setOnClickListener(layoutView -> {
            NavDirections action = LiveFitnessFragmentDirections
                    .actionLiveFitnessFragmentToUpcomingListFragment();
            Navigation.findNavController(binding.getRoot()).navigate(action);
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        liveFitnessViewModel = new ViewModelProvider(requireActivity()).get(FakeLiveFitnessViewModel.class);
        liveFitnessViewModel.getLiveFitnessListUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingLiveFitnessList()) {

                    }
                    else {
                        //updateUI(result.getLiveFitnessList());
                        updateUI(new ArrayList<>());
                    }
                }
        );
    }

    private void updateUI(List<LiveFitness> liveFitnessList) {
        if (liveFitnessList.isEmpty()) {
            binding.recyclerView.setVisibility(View.GONE);
            binding.seeAllTextView.setVisibility(View.GONE);
            binding.upcomingItemLayout.getRoot().setVisibility(View.GONE);
            binding.noLiveFitnessVideosTextView.setVisibility(View.VISIBLE);
        }
        else {
            binding.recyclerView.setVisibility(View.VISIBLE);
            binding.seeAllTextView.setVisibility(View.VISIBLE);
            binding.upcomingItemLayout.getRoot().setVisibility(View.VISIBLE);
            binding.noLiveFitnessVideosTextView.setVisibility(View.GONE);

        }
        for (LiveFitness liveFitness : liveFitnessList) {
            int imageResource = getResources().getIdentifier(liveFitness.getBackgroundUri(), null,
                    requireActivity().getPackageName());
            liveFitness.setBackgroundImageDrawableResource(imageResource);
        }
        binding.upcomingItemLayout.nameTextView.setText(R.string.upcoming_live);
        binding.upcomingItemLayout.bookingsNumberTextView.setText("1385");
        int imageResource = getResources().getIdentifier("@drawable/upcoming_live", null,
                requireActivity().getPackageName());
        binding.upcomingItemLayout.getRoot().setBackgroundResource(imageResource);
        LiveFitnessAdapter liveFitnessAdapter
                = new LiveFitnessAdapter(liveFitnessList, getContext(),
                this::navigateToLiveFitnessItemFragment);
        binding.recyclerView.setAdapter(liveFitnessAdapter);

    }

    private void navigateToLiveFitnessItemFragment(LiveFitness liveFitness) {
        if (liveFitness.getLiveFitnessDetail() == null) {
            return;
        }
        liveFitnessViewModel.setSelectedLiveFitness(liveFitness);
        NavDirections action = LiveFitnessFragmentDirections
                .actionLiveFitnessFragmentToLiveFitnessItemFragment();
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}