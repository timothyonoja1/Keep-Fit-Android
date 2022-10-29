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
import com.kratos.keepfit.databinding.FragmentFitnessCategoriesBinding;
import com.kratos.keepfit.entities.FitnessCategory;
import com.kratos.keepfit.viewmodels.interfaces.FitnessProgrammesViewModel;
import com.kratos.keepfit.viewmodels.real.FitnessProgrammeViewModelImpl;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class FitnessCategoriesFragment extends Fragment {

    private FragmentFitnessCategoriesBinding binding;
    private FitnessProgrammesViewModel fitnessProgrammesViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFitnessCategoriesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.circuitTrainingView.setOnClickListener(buttonView -> {
            fitnessProgrammesViewModel.setSelectedFitnessCategory(
                    new FitnessCategory(1, "Circuit Training")
            );
            NavDirections detailsAction = FitnessCategoriesFragmentDirections
                    .actionFitnessCategoriesFragmentToFitnessProgrammeListFragment();
            Navigation.findNavController(buttonView).navigate(detailsAction);
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        fitnessProgrammesViewModel = new ViewModelProvider(requireActivity()).get(FitnessProgrammeViewModelImpl.class);
        fitnessProgrammesViewModel.getFitnessCategoryListUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingFitnessCategoryLists()){

                    }
                    else {
                        binding.circuitTrainingTextView.setText(
                                result.getNumberOfFitnessProgrammes().get(0)
                        );
                    }
                }
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}