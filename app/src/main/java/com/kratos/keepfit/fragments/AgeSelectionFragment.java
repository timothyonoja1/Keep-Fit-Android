package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.kratos.keepfit.R;
import com.kratos.keepfit.databinding.FragmentAgeSelectionBinding;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class AgeSelectionFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmentAgeSelectionBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAgeSelectionBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.nextButton.setOnClickListener(buttonView -> {
            NavDirections action = AgeSelectionFragmentDirections
                    .actionAgeSelectionFragmentToEnterDetailsFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });
        binding.spinner.setOnItemSelectedListener(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.ages_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        String selectedAge = (String) parent.getItemAtPosition(position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}