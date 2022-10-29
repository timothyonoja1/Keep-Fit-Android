package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kratos.keepfit.adapters.FitnessVideoAdapter;
import com.kratos.keepfit.databinding.FragmentFitnessVideoListBinding;
import com.kratos.keepfit.entities.FitnessProgramme;
import com.kratos.keepfit.entities.FitnessVideo;
import com.kratos.keepfit.viewmodels.interfaces.FitnessProgrammesViewModel;
import com.kratos.keepfit.viewmodels.real.FitnessProgrammeViewModelImpl;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class FitnessVideoListFragment extends Fragment {

    private FragmentFitnessVideoListBinding binding;
    private FitnessProgrammesViewModel fitnessProgrammesViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFitnessVideoListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fitnessProgrammesViewModel = new ViewModelProvider(requireActivity()).get(
                FitnessProgrammeViewModelImpl.class);
        fitnessProgrammesViewModel.getFitnessVideoListUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingVideoList()) {

                    }
                    else {
                        updateUI(result.getFitnessVideoList(), result.getSelectedFitnessProgramme());
                    }
                }
        );
    }

    private void updateUI(List<FitnessVideo> fitnessVideos, FitnessProgramme selectedFitnessProgramme){
        binding.fitnessClassTitleTextView.setText(selectedFitnessProgramme.getTitle());
        binding.numberOfSessionsTextView.setText(selectedFitnessProgramme.getNumberOfSessions());
        binding.numberOfWeeksTextView.setText(selectedFitnessProgramme.getNumberOfWeeks());
        binding.notesTextView.setText(selectedFitnessProgramme.getNote());
        int imageResource = getResources().getIdentifier(selectedFitnessProgramme.getImageUri(),
                null, requireActivity().getPackageName());
        ImageView img = new ImageView(getContext());
        Picasso.get().load(imageResource).into(img, new Callback() {
            @Override
            public void onSuccess() {
                binding.fitnessClassImageTextView.setBackground(img.getDrawable());
            }

            @Override
            public void onError(Exception e) {

            }
        });
        for (FitnessVideo fitnessVideo : fitnessVideos) {
            imageResource = getResources().getIdentifier(fitnessVideo.getImageUri(),
                    null, requireActivity().getPackageName());
            fitnessVideo.setDrawableResource(imageResource);
        }
        FitnessVideoAdapter fitnessVideoAdapter = new FitnessVideoAdapter(
                fitnessVideos, this::navigateToFitnessVideoWatchFragment, getContext());
        binding.recyclerView.setAdapter(fitnessVideoAdapter);
    }

    private void navigateToFitnessVideoWatchFragment(FitnessVideo fitnessVideo) {
        if (fitnessVideo.getVideoUrl() == null) {
            return;
        }
        fitnessProgrammesViewModel.setSelectedFitnessVideo(fitnessVideo);
        NavDirections loginAction = FitnessVideoListFragmentDirections
                .actionFitnessVideoListFragmentToFitnessVideoWatchFragment();
        Navigation.findNavController(binding.getRoot()).navigate(loginAction);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}