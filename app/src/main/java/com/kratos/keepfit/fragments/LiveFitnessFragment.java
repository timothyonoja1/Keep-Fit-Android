package com.kratos.keepfit.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kratos.keepfit.adapters.LiveFitnessAdapter;
import com.kratos.keepfit.core.LiveFitness;
import com.kratos.keepfit.databinding.FragmentLiveFitnessBinding;
import java.util.ArrayList;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class LiveFitnessFragment extends Fragment {

    private FragmentLiveFitnessBinding binding;
    private final List<LiveFitness> liveFitnessList = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLiveFitnessBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String uri1 = "@drawable/quick_core_crush";
        String uri2 = "@drawable/pregnant_mums";
        String uri3 = "@drawable/south_paw_training";
        String uri4 = "@drawable/upcoming_live";
        List<String> uris = new ArrayList<>();
        uris.add(uri1);
        uris.add(uri2);
        uris.add(uri3);
        uris.add(uri4);

        List<String> names = new ArrayList<>();
        names.add("Quick Core Crush");
        names.add("Pregnant mums");
        names.add("Southpaw Training");
        names.add("Upcoming Live");

        int i = 0;
        while (i < 4){
            int imageResource = getResources().getIdentifier(uris.get(i), null, requireActivity().getPackageName());
            liveFitnessList.add(new LiveFitness(1, "", "", imageResource));
            ++i;
        }

        updateUI();
    }

    private void updateUI() {
        LiveFitnessAdapter liveFitnessAdapter = new LiveFitnessAdapter(liveFitnessList, getContext());
        binding.recyclerView.setAdapter(liveFitnessAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}