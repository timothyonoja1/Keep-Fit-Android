package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.kratos.keepfit.databinding.FragmentSuccessfulBookingBinding;
import com.kratos.keepfit.entities.Upcoming;
import com.kratos.keepfit.entities.UpcomingDetail;
import com.kratos.keepfit.viewmodels.fakes.FakeUpcomingViewModel;
import com.kratos.keepfit.viewmodels.interfaces.UpcomingViewModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class SuccessfulBookingFragment extends Fragment {

    private FragmentSuccessfulBookingBinding binding;
    private UpcomingViewModel upcomingViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSuccessfulBookingBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.addToCalendar.setOnClickListener(buttonView -> {

        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        upcomingViewModel = new ViewModelProvider(requireActivity()).get(FakeUpcomingViewModel.class);
        upcomingViewModel.getUpcomingItemUiState().observe(
                getViewLifecycleOwner(), result -> {
                    updateUI(result.getSelectedUpcomingItem());
                }
        );
    }

    private void updateUI(Upcoming selectedUpcomingItem) {
        UpcomingDetail upcomingDetail = selectedUpcomingItem.getUpcomingDetail();
        if (upcomingDetail == null) {
            return;
        }
        binding.nameTextView.setText(selectedUpcomingItem.getName());
        binding.dateTimeTextView.setText(upcomingDetail.getDateTime());
        binding.authorNameTextView.setText(upcomingDetail.getAuthorName());

        ImageView img = new ImageView(getContext());
        Picasso.get().load(getDrawableResourceID(upcomingDetail.getBackgroundImageUri())).into(img, new Callback() {
            @Override
            public void onSuccess() {
                binding.getRoot().setBackground(img.getDrawable());
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    private int getDrawableResourceID(String imageUri) {
        return getResources().getIdentifier(imageUri, null, requireActivity().getPackageName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
