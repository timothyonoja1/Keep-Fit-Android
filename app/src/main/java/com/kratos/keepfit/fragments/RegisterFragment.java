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
import com.kratos.keepfit.databinding.FragmentRegisterBinding;
import com.kratos.keepfit.states.AuthenticationUiStatus;
import com.kratos.keepfit.viewmodels.interfaces.AuthenticationViewModel;
import com.kratos.keepfit.viewmodels.real.AuthenticationViewModelImpl;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;
    private AuthenticationViewModel authenticationViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.signInLinkTextView.setOnClickListener(buttonView -> {
            NavDirections action = RegisterFragmentDirections
                    .actionRegisterFragmentToLoginFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });
        binding.confirmButton.setOnClickListener(buttonView -> {
            authenticationViewModel.generateVerificationCode(
                    binding.emailEditText.getText().toString(),
                    binding.passwordEditText.getText().toString(),
                    binding.passwordEditText.getText().toString(),
                    binding.nameEditText.getText().toString()
            );
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authenticationViewModel = new ViewModelProvider(requireActivity()).get(AuthenticationViewModelImpl.class);
        authenticationViewModel.getGenerateVerificationCodeUiState().observe(getViewLifecycleOwner(),
                result -> updateUI(result.getAuthenticationUiStatus(), result.getErrorMessage())
        );
    }

    private void updateUI(AuthenticationUiStatus authenticationUiStatus, String errorMessage) {
        switch (authenticationUiStatus){
            case GeneratingCode:
                showLoadingUi();
                break;
            case CodeGeneratedSuccessfully:
                NavDirections action = RegisterFragmentDirections
                        .actionRegisterFragmentToVerifyFragment();
                Navigation.findNavController(binding.getRoot()).navigate(action);
                break;
            case InvalidInput:
            case Failure:
                hideLoadingUi();
                binding.errorTextView.setText(errorMessage);
                break;
            default:
                hideLoadingUi();
                break;
        }
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