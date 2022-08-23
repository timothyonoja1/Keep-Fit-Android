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
import com.kratos.keepfit.adapters.TrainingAdapter;
import com.kratos.keepfit.entities.Training;
import com.kratos.keepfit.databinding.FragmentTrainingListBinding;
import com.kratos.keepfit.viewmodels.fakes.FakeTrainingViewModel;
import com.kratos.keepfit.viewmodels.interfaces.TrainingViewModel;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class TrainingListFragment extends Fragment {

    private FragmentTrainingListBinding binding;
    private TrainingViewModel trainingViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTrainingListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        trainingViewModel = new ViewModelProvider(requireActivity()).get(FakeTrainingViewModel.class);
        trainingViewModel.getTrainingListUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingTrainingLists()){

                    }
                    else {
                        updateUI(result.getTrainingList());
                    }
                }
        );
    }

    private void updateUI(List<Training> trainings){
        TrainingAdapter trainingAdapter = new TrainingAdapter(trainings,
                this::navigateToSectionListFragment);
        binding.recyclerView.setAdapter(trainingAdapter);
    }

    private void navigateToSectionListFragment(Training training){
        trainingViewModel.setSelectedTraining(training);
        NavDirections loginAction = TrainingListFragmentDirections
                .actionTrainingListFragmentToTrainingSessionListFragment();
        Navigation.findNavController(binding.getRoot()).navigate(loginAction);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}