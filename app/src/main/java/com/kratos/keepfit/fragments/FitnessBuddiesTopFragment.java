package com.kratos.keepfit.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kratos.keepfit.adapters.FitnessBuddyAdapter;
import com.kratos.keepfit.adapters.PendingAcceptanceAdapter;
import com.kratos.keepfit.core.FitnessBuddy;
import com.kratos.keepfit.databinding.FragmentFitnessBuddiesTopBinding;
import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class FitnessBuddiesTopFragment  extends Fragment {

    private FragmentFitnessBuddiesTopBinding binding;
    private final List<FitnessBuddy> fitnessBuddyList = new ArrayList<>();
    private final List<String> pendingAcceptanceNames = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFitnessBuddiesTopBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.fitnessBuddiesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.pendingAcceptanceRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> uris = new ArrayList<>();
        uris.add("@drawable/tania_dp");
        uris.add("@drawable/leon_small_dp");
        uris.add("@drawable/adeola_dp");
        uris.add("@drawable/tim_spent_dp");

        List<String> names = new ArrayList<>();
        names.add("Tania Hardy");
        names.add("Leon Small");
        names.add("Ade Ola");
        names.add("Tim Spent");

        List<String> pendingNames = new ArrayList<>();
        pendingNames.add("Kritina Clark");
        pendingNames.add("St. Louis Maria");
        pendingNames.add("St. Gading Kasri");
        pendingNames.add("St. Tim Onoja");

        List<String> description = new ArrayList<>();
        description.add("0.31 mi away. Fitness");
        description.add("1.23 mi away. Aerobic");
        description.add("0.48 mi away. Boxing");
        description.add("1.47 mi away. Body Building");

        int i = 0;
        while (i < 4){
            int imageResource = getResources().getIdentifier(uris.get(i), null, requireActivity().getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            fitnessBuddyList.add(new FitnessBuddy(names.get(i), "", "", description.get(i), res));
            pendingAcceptanceNames.add(pendingNames.get(i));
            ++i;
        }

        updateUI();

    }

    private void updateUI() {
        FitnessBuddyAdapter fitnessBuddyAdapter = new FitnessBuddyAdapter(fitnessBuddyList);
        binding.fitnessBuddiesRecyclerView.setAdapter(fitnessBuddyAdapter);

        PendingAcceptanceAdapter pendingAcceptanceAdapter = new PendingAcceptanceAdapter(pendingAcceptanceNames);
        binding.pendingAcceptanceRecyclerView.setAdapter(pendingAcceptanceAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
