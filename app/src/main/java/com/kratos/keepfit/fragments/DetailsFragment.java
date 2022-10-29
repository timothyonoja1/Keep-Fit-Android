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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kratos.keepfit.adapters.AllergyAdapter;
import com.kratos.keepfit.adapters.FitnessGoalAdapter;
import com.kratos.keepfit.adapters.WeeklyTrainingDurationAdapter;
import com.kratos.keepfit.databinding.FragmentDetailsBinding;
import com.kratos.keepfit.entities.Allergy;
import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import com.kratos.keepfit.states.DetailsUiState;
import com.kratos.keepfit.viewmodels.interfaces.DetailsViewModel;
import com.kratos.keepfit.viewmodels.real.DetailsViewModelImpl;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class DetailsFragment extends Fragment {

    private FragmentDetailsBinding binding;
    private DetailsViewModel detailsViewModel;
    private boolean isLoggedIn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.fitnessGoalListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.weeklyTrainingDurationListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.allergyListRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        binding.confirmButton.setOnClickListener(buttonView -> detailsViewModel.confirm());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        detailsViewModel = new ViewModelProvider(requireActivity()).get(DetailsViewModelImpl.class);
        detailsViewModel.getDetailsUiState().observe(
                getViewLifecycleOwner(), this::updateUI
        );
    }

    private void updateUI(DetailsUiState detailsUiState) {
        isLoggedIn = detailsUiState.isLoogedInUser();
        switch (detailsUiState.getDetailsUiStatus()){
            case Idle:
                hideLoadingUi();
                break;
            case DetailsUiStateLoading:
            case SubmittingDetails:
                showLoadingUi();
                break;
            case DetailsUiStateLoaded:
                hideLoadingUi();
                updateFitnessGoalList(detailsUiState.getFitnessGoals());
                updateWeeklyTrainingDurationList(detailsUiState.getWeeklyTrainingDurations());
                updateAllergyList(detailsUiState.getAllergies());
                break;
            case InputError:
            case DetailsUiStateLoadingFailure:
            case DetailsSubmissionFailure:
                hideLoadingUi();
                binding.errorTextView.setText(detailsUiState.getErrorMessage());
                break;
            case DetailsSubmissionSuccess:
                hideLoadingUi();
                if (isLoggedIn) {
                    NavDirections action = DetailsFragmentDirections.actionDetailsFragmentToHomeFragment();
                    Navigation.findNavController(binding.getRoot()).navigate(action);
                }
                else {
                    NavDirections action = DetailsFragmentDirections.actionDetailsFragmentToMainFragment();
                    Navigation.findNavController(binding.getRoot()).navigate(action);
                }
                break;
        }
    }

    private void updateFitnessGoalList(List<FitnessGoal> fitnessGoals) {
        FitnessGoalAdapter fitnessGoalAdapter
                = new FitnessGoalAdapter(fitnessGoals, this::onClickFitnessGoal);
        binding.fitnessGoalListRecyclerView.setAdapter(fitnessGoalAdapter);
    }

    private void updateWeeklyTrainingDurationList(List<WeeklyTrainingDuration> weeklyTrainingDurations){
        WeeklyTrainingDurationAdapter weeklyTrainingDurationAdapter
                = new WeeklyTrainingDurationAdapter(weeklyTrainingDurations, this::onClickWeeklyTrainingDuration);
        binding.weeklyTrainingDurationListRecyclerView.setAdapter(weeklyTrainingDurationAdapter);
    }

    private void updateAllergyList(List<Allergy> allergies) {
        AllergyAdapter allergyAdapter
                = new AllergyAdapter(allergies, requireContext(), this::onClickAllergy);
        binding.allergyListRecyclerView.setAdapter(allergyAdapter);
    }

    private void onClickFitnessGoal(FitnessGoal fitnessGoal) {
        detailsViewModel.onClick(fitnessGoal);
    }

    private void onClickWeeklyTrainingDuration(WeeklyTrainingDuration weeklyTrainingDuration) {
        detailsViewModel.onClick(weeklyTrainingDuration);
    }

    private void onClickAllergy(Allergy allergy) {
        detailsViewModel.onClick(allergy);
    }

    private void showLoadingUi(){
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.confirmButton.setEnabled(false);
    }

    private void hideLoadingUi(){
        binding.progressBar.setVisibility(View.GONE);
        binding.confirmButton.setEnabled(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}