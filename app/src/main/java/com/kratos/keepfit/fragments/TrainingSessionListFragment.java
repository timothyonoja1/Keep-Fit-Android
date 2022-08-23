package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kratos.keepfit.adapters.TrainingSessionAdapter;
import com.kratos.keepfit.databinding.FragmentTrainingSessionListBinding;
import com.kratos.keepfit.entities.Training;
import com.kratos.keepfit.entities.TrainingSession;
import com.kratos.keepfit.viewmodels.fakes.FakeTrainingViewModel;
import com.kratos.keepfit.viewmodels.interfaces.TrainingViewModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class TrainingSessionListFragment extends Fragment {

    private FragmentTrainingSessionListBinding binding;
    private TrainingViewModel trainingViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTrainingSessionListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        trainingViewModel = new ViewModelProvider(requireActivity()).get(FakeTrainingViewModel.class);
        trainingViewModel.getTrainingSessionListUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingTrainingSectionList()) {

                    }
                    else {
                        updateUI(result.getTrainingSessionList(), result.getSelectedTraining());
                    }
                }
        );
    }

    private void updateUI(List<TrainingSession> trainingSessions, Training selectedTraining){
        binding.trainingTitleTextView.setText(selectedTraining.getTitle());
        binding.numberOfSessionsTextView.setText(selectedTraining.getNumberOfSessions());
        binding.numberOfWeeksTextView.setText(selectedTraining.getNumberOfWeeks());
        binding.notesTextView.setText(selectedTraining.getNotes());
        int imageResource = getResources().getIdentifier(selectedTraining.getImageUri(),
                null, requireActivity().getPackageName());
        ImageView img = new ImageView(getContext());
        Picasso.get().load(imageResource).into(img, new Callback() {
            @Override
            public void onSuccess() {
                binding.trainingImageTextView.setBackground(img.getDrawable());
            }

            @Override
            public void onError(Exception e) {

            }
        });
        for (TrainingSession trainingSession : trainingSessions) {
            imageResource = getResources().getIdentifier(trainingSession.getImageUri(),
                    null, requireActivity().getPackageName());
            trainingSession.setDrawableResource(imageResource);
        }
        TrainingSessionAdapter trainingSessionAdapter = new TrainingSessionAdapter(
                trainingSessions, getContext());
        binding.recyclerView.setAdapter(trainingSessionAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}