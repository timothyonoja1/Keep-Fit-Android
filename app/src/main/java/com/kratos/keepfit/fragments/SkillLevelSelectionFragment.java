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
import com.kratos.keepfit.adapters.SkillLevelAdapter;
import com.kratos.keepfit.databinding.FragmentSkillLevelSelectionBinding;
import com.kratos.keepfit.entities.SkillLevel;
import com.kratos.keepfit.viewmodels.fakes.FakeSearchAndMatchViewModel;
import com.kratos.keepfit.viewmodels.interfaces.SearchAndMatchViewModel;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SkillLevelSelectionFragment extends Fragment {

    private FragmentSkillLevelSelectionBinding binding;
    private SearchAndMatchViewModel searchAndMatchViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSkillLevelSelectionBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.nextButton.setOnClickListener(buttonView -> {
            NavDirections action = SkillLevelSelectionFragmentDirections
                    .actionSkillLevelSelectionFragmentToEnterDetailsFragment();
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
                        updateUI(result.getSkillLevels());
                    }
                }
        );
    }

    private void updateUI(List<SkillLevel> skillLevels) {
        SkillLevelAdapter skillLevelAdapter
                = new SkillLevelAdapter(skillLevels, this::onClickSkillLevel);
        binding.recyclerView.setAdapter(skillLevelAdapter);
    }

    private void onClickSkillLevel(SkillLevel skillLevel) {
        searchAndMatchViewModel.onClickSkillLevel(skillLevel);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
