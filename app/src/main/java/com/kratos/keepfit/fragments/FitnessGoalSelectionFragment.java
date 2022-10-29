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
import com.kratos.keepfit.adapters.FitnessGoalAdapter;
import com.kratos.keepfit.databinding.FragmentFitnessGoalSelectionBinding;
import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.viewmodels.fakes.FakeSearchAndMatchViewModel;
import com.kratos.keepfit.viewmodels.interfaces.SearchAndMatchViewModel;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FitnessGoalSelectionFragment extends Fragment {

    private FragmentFitnessGoalSelectionBinding binding;
    private SearchAndMatchViewModel searchAndMatchViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFitnessGoalSelectionBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.nextButton.setOnClickListener(buttonView -> {
            NavDirections action = FitnessGoalSelectionFragmentDirections
                    .actionFitnessGoalSelectionFragmentToEnterDetailsFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchAndMatchViewModel = new ViewModelProvider(requireActivity()).get(FakeSearchAndMatchViewModel.class);
        searchAndMatchViewModel.getSearchAndMatchUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingFitnessGoals()) {

                    }
                    else {
                        updateUI(result.getFitnessGoals());
                    }
                }
        );
    }

    private void updateUI(List<FitnessGoal> fitnessGoals) {
        FitnessGoalAdapter fitnessGoalAdapter
                = new FitnessGoalAdapter(fitnessGoals, this::onClickFitnessGoal);
        binding.recyclerView.setAdapter(fitnessGoalAdapter);
    }

    private void onClickFitnessGoal(FitnessGoal fitnessGoal) {
        searchAndMatchViewModel.onClickFitnessGoal(fitnessGoal);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}