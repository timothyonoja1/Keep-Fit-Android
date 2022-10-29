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
import com.kratos.keepfit.databinding.FragmentWeightSelectionBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WeightSelectionFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmentWeightSelectionBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWeightSelectionBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.nextButton.setOnClickListener(buttonView -> {
            NavDirections action = WeightSelectionFragmentDirections
                    .actionWeightSelectionFragmentToEnterDetailsFragment();
            Navigation.findNavController(binding.getRoot()).navigate(action);
        });
        binding.spinner.setOnItemSelectedListener(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.weight_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

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
