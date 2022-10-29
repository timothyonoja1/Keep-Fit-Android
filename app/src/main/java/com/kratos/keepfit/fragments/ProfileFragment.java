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
import com.kratos.keepfit.R;
import com.kratos.keepfit.databinding.FragmentProfileBinding;
import com.kratos.keepfit.states.ProfileUiState;
import com.kratos.keepfit.viewmodels.interfaces.ProfileViewModel;
import com.kratos.keepfit.viewmodels.real.ProfileViewModelImpl;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private ProfileViewModel profileViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.editProfileButton.setOnClickListener(buttonView -> {
            NavDirections action = ProfileFragmentDirections.actionUserFragmentToStep1Fragment();
            Navigation.findNavController(buttonView).navigate(action);
        });
        binding.logoutLinkView.setOnClickListener(buttonView -> {
            profileViewModel.logout();
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        profileViewModel = new ViewModelProvider(requireActivity()).get(ProfileViewModelImpl.class);
        profileViewModel.getProfileUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingUiState()) {

                    }
                    else {
                        updateUI(result);
                    }
                }
        );
    }

    private void updateUI(ProfileUiState profileUiState) {
        binding.nameTextView.setText(profileUiState.getUserProfile().getFirstname());
        binding.skillLevelTextView.setText(profileUiState.getSkillLevel());
        binding.numberOfSessionsTextView.setText(
                String.format("\t %s \n Sessions", profileUiState.getUserProfileDetail().getNumberOfSessions())
        );

        ImageView img = new ImageView(requireContext());
        Picasso.get().load("https://facebook.com/image.jpg")
                .placeholder(R.drawable.grey_background).error(R.drawable.grey_background)
                .into(img, new Callback() {
                    @Override
                    public void onSuccess() {
                        binding.profilePictureTextView.setBackground(img.getDrawable());
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
