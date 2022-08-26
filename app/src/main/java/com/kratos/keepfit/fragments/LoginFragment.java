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
import com.kratos.keepfit.databinding.FragmentLoginBinding;
import com.kratos.keepfit.states.AuthenticationUiStatus;
import com.kratos.keepfit.viewmodels.fakes.FakeAuthenticationViewModel;
import com.kratos.keepfit.viewmodels.interfaces.AuthenticationViewModel;
import com.kratos.keepfit.viewmodels.real.AuthenticationViewModelImpl;

import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private AuthenticationViewModel authenticationViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.loginButtonEditText.setOnClickListener(buttonView -> {
            authenticationViewModel.login(
                binding.emailEditText.getText().toString(), binding.passwordEditText.getText().toString()
            );
        });
        binding.forgotPasswordLinkTextView.setOnClickListener(buttonView -> {
            NavDirections action = LoginFragmentDirections
                    .actionLoginFragmentToForgotPasswordFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authenticationViewModel = new ViewModelProvider(requireActivity()).get(AuthenticationViewModelImpl.class);
        authenticationViewModel.getLoginUiState().observe(getViewLifecycleOwner(),
                result -> updateUI(result.getAuthenticationUiStatus(), result.getErrorMessage())
        );
    }

    private void updateUI(AuthenticationUiStatus authenticationUiStatus, String errorMessage){
        switch (authenticationUiStatus){
            case LoggingIn:
                showLoadingUi();
                break;
            case LoginSuccessful:
                hideLoadingUi();
                NavDirections action = LoginFragmentDirections
                        .actionLoginFragmentToHomeFragment();
                Navigation.findNavController(binding.getRoot()).navigate(action);
                break;
            case InvalidInput:
            case Failure:
                binding.errorTextView.setText(errorMessage);
                hideLoadingUi();
                break;
            default:
                hideLoadingUi();
                break;
        }
    }

    private void showLoadingUi() {
        binding.progressBar.setVisibility(View.GONE);
        binding.loginButtonEditText.setEnabled(true);
    }

    private void hideLoadingUi() {
        binding.progressBar.setVisibility(View.GONE);
       binding.loginButtonEditText.setEnabled(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}