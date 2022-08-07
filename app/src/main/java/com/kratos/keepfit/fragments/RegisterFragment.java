package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.kratos.keepfit.R;
import com.kratos.keepfit.databinding.FragmentRegisterBinding;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.signInLinkTextView.setOnClickListener(buttonView ->
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_activity_fragment_container_view,
                                LoginFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)  // name can be null
                        .commit()
        );
        binding.confirmButton.setOnClickListener(buttonView ->
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_activity_fragment_container_view,
                                EnterNameFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)  // name can be null
                        .commit()
        );
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
