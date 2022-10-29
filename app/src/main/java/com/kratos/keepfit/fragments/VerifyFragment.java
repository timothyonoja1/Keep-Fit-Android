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
public class VerifyFragment extends Fragment {

    private FragmentVerifyYourEmailBinding binding;
    private AuthenticationViewModel authenticationViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentVerifyYourEmailBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.verifyButton.setOnClickListener(buttonView ->
                authenticationViewModel.register(binding.codeEditText.getText().toString()));
        binding.signInLinkTextView.setOnClickListener(buttonView -> {
            NavDirections action = VerifyFragmentDirections
                    .actionVerifyFragmentToLoginFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authenticationViewModel = new ViewModelProvider(requireActivity()).get(AuthenticationViewModelImpl.class);
        authenticationViewModel.getRegistrationUiState().observe(getViewLifecycleOwner(),
                result -> updateUI(result.getAuthenticationUiStatus(), result.getErrorMessage())
        );
        authenticationViewModel.register("123456");
    }

    private void updateUI(AuthenticationUiStatus authenticationUiStatus, String errorMessage) {
        switch (authenticationUiStatus){
            case Registering:
            case RegistrationSuccessful:
            case LoggingIn:
                showLoadingUi();
                break;
            case LoginSuccessful:
                hideLoadingUi();
                NavDirections action = VerifyFragmentDirections
                        .actionVerifyFragmentToHomeFragment();
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