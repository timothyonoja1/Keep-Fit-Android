package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import com.kratos.keepfit.databinding.FragmentAuthBinding;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class AuthFragment extends Fragment {
    
    private FragmentAuthBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAuthBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.getStarted.setOnClickListener(buttonView -> {
            NavDirections detailsAction = AuthFragmentDirections
                    .actionAuthenticationFragmentToDetailsFragment();
            Navigation.findNavController(buttonView).navigate(detailsAction);
        });
        binding.loginLinkTextView.setOnClickListener(buttonView -> {
            NavDirections loginAction = AuthFragmentDirections
                    .actionAuthenticationFragmentToLoginFragment();
            Navigation.findNavController(buttonView).navigate(loginAction);
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
