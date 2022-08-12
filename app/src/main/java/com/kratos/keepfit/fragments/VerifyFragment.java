package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import com.kratos.keepfit.databinding.FragmentVerifyYourEmailBinding;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class VerifyFragment extends Fragment {

    private FragmentVerifyYourEmailBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentVerifyYourEmailBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.verifyButton.setOnClickListener(buttonView -> {
            NavDirections action = VerifyFragmentDirections
                    .actionVerifyFragmentToHomeFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });
        binding.signInLinkTextView.setOnClickListener(buttonView -> {
            NavDirections action = VerifyFragmentDirections
                    .actionVerifyFragmentToLoginFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
