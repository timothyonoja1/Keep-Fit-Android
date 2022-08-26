package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.kratos.keepfit.databinding.FragmentLiveFitnessItemBinding;
import com.kratos.keepfit.entities.LiveFitness;
import com.kratos.keepfit.entities.LiveFitnessDetail;
import com.kratos.keepfit.viewmodels.fakes.FakeLiveFitnessViewModel;
import com.kratos.keepfit.viewmodels.interfaces.LiveFitnessViewModel;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class LiveFitnessItemFragment extends Fragment {

    private FragmentLiveFitnessItemBinding binding;
    private LiveFitnessViewModel liveFitnessViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLiveFitnessItemBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        liveFitnessViewModel = new ViewModelProvider(requireActivity()).get(FakeLiveFitnessViewModel.class);
        liveFitnessViewModel.getLiveFitnessItemUiState().observe(
                getViewLifecycleOwner(), result -> {
                    updateUI(result.getSelectedLiveFitness());
                }
        );
    }

    private void updateUI(LiveFitness liveFitness) {
        LiveFitnessDetail liveFitnessDetail = liveFitness.getLiveFitnessDetail();
        if (liveFitnessDetail == null) {
            return;
        }
        binding.authorNameTextView.setText(liveFitnessDetail.getAuthorName());
        binding.itemNameTextView.setText(liveFitnessDetail.getItemName());
        binding.descriptionTextView.setText(liveFitnessDetail.getDescription());
        binding.numberOfStreamersTextView.setText(liveFitnessDetail.getNumberOfStreamers());
        binding.authorDpImageView.setBackgroundResource(
                getDrawableResource(liveFitnessDetail.getAuthorImageUri())
        );
        binding.getRoot().setBackgroundResource(
                getDrawableResource(liveFitnessDetail.getBackgroundImageUri())
        );
        binding.streamingUser1ImageView.setBackgroundResource(
                getDrawableResource(liveFitnessDetail.getStreamingUser1ImageUri())
        );
        binding.streamingUser2ImageView.setBackgroundResource(
                getDrawableResource(liveFitnessDetail.getStreamingUser2ImageUri())
        );
    }

    private int getDrawableResource(String imageUri) {
        return getResources().getIdentifier(imageUri, null, requireActivity().getPackageName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}