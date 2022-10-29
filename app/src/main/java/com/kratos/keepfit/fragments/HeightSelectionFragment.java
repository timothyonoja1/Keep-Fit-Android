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
import com.kratos.keepfit.databinding.FragmentHeightSelectionBinding;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HeightSelectionFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmentHeightSelectionBinding binding;
    private HeightSelectionFragment heightSelectionFragment;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHeightSelectionBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.nextButton.setOnClickListener(buttonView -> {
            NavDirections action = HeightSelectionFragmentDirections
                    .actionHeightSelectionFragmentToEnterDetailsFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });

        binding.ftSpinner.setOnItemSelectedListener(this);
        binding.inchSpinner.setOnItemSelectedListener(this);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<CharSequence> feetAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.feet_array, android.R.layout.simple_spinner_item);
        feetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.ftSpinner.setAdapter(feetAdapter);

        ArrayAdapter<CharSequence> inchAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.inch_array, android.R.layout.simple_spinner_item);
        feetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.inchSpinner.setAdapter(inchAdapter);
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
