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
import com.kratos.keepfit.adapters.FitnessProgrammeAdapter;
import com.kratos.keepfit.databinding.FragmentFitnessProgrammeListBinding;
import com.kratos.keepfit.entities.FitnessProgramme;
import com.kratos.keepfit.viewmodels.interfaces.FitnessProgrammesViewModel;
import com.kratos.keepfit.viewmodels.real.FitnessProgrammeViewModelImpl;

import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class FitnessProgrammeListFragment extends Fragment {

    private FragmentFitnessProgrammeListBinding binding;
    private FitnessProgrammesViewModel fitnessProgrammesViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFitnessProgrammeListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fitnessProgrammesViewModel = new ViewModelProvider(requireActivity()).get(
                FitnessProgrammeViewModelImpl.class);
        fitnessProgrammesViewModel.getFitnessProgrammeListUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingFitnessProgrammeLists()){

                    }
                    else {
                        updateUI(result.getFitnessProgrammeList());
                    }
                }
        );
    }

    private void updateUI(List<FitnessProgramme> fitnessProgrammes){
        FitnessProgrammeAdapter fitnessCLassAdapter = new FitnessProgrammeAdapter(fitnessProgrammes,
                this::navigateToFitnessVideoListFragment);
        binding.recyclerView.setAdapter(fitnessCLassAdapter);
    }

    private void navigateToFitnessVideoListFragment(FitnessProgramme fitnessProgramme){
        fitnessProgrammesViewModel.setSelectedFitnessProgramme(fitnessProgramme);
        NavDirections loginAction = FitnessProgrammeListFragmentDirections
                .actionFitnessProgrammeListFragmentToFitnessVideoListFragment();
        Navigation.findNavController(binding.getRoot()).navigate(loginAction);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}