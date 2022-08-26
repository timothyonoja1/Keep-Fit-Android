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
import com.kratos.keepfit.databinding.FragmentVerifyYourEmailBinding;
import com.kratos.keepfit.states.AuthenticationUiStatus;
import com.kratos.keepfit.viewmodels.fakes.FakeAuthenticationViewModel;
import com.kratos.keepfit.viewmodels.interfaces.AuthenticationViewModel;
import com.kratos.keepfit.viewmodels.real.AuthenticationViewModelImpl;

import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class ForgotPasswordVerificationFragment extends Fragment {

    private FragmentVerifyYourEmailBinding binding;
    private AuthenticationViewModel authenticationViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentVerifyYourEmailBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.verifyButton.setOnClickListener(buttonView -> authenticationViewModel.verifyEmailCode(
                binding.codeEditText.getText().toString()
        ));
        binding.signInLinkTextView.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authenticationViewModel = new ViewModelProvider(requireActivity()).get(AuthenticationViewModelImpl.class);
        authenticationViewModel.getEmailVerificationCodeUiState().observe(getViewLifecycleOwner(),
                result -> updateUI(result.getAuthenticationUiStatus(), result.getErrorMessage())
        );
    }

    private void updateUI(AuthenticationUiStatus authenticationUiStatus, String errorMessage){
        switch (authenticationUiStatus){
            case VerifyingCode:
                showLoadingUi();
                break;
            case CodeVerificationSuccessful:
                hideLoadingUi();
                NavDirections action = ForgotPasswordVerificationFragmentDirections
                        .actionForgotPasswordVerificationFragmentToResetPasswordFragment();
                Navigation.findNavController(binding.getRoot()).navigate(action);
                break;
            case InvalidInput:
            case Failure:
                hideLoadingUi();
                binding.errorTextView.setText(errorMessage);
                binding.verifyButton.setEnabled(true);
                break;
            default:
                hideLoadingUi();
                break;
        }
    }

    private void showLoadingUi(){
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.verifyButton.setEnabled(false);
    }

    private void hideLoadingUi(){
        binding.progressBar.setVisibility(View.GONE);
        binding.verifyButton.setEnabled(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}