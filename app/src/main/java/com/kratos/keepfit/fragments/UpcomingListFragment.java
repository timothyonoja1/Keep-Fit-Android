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
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kratos.keepfit.adapters.UpcomingAdapter;
import com.kratos.keepfit.databinding.FragmentUpcomingListBinding;
import com.kratos.keepfit.entities.Upcoming;
import com.kratos.keepfit.viewmodels.fakes.FakeLiveFitnessViewModel;
import com.kratos.keepfit.viewmodels.fakes.FakeUpcomingViewModel;
import com.kratos.keepfit.viewmodels.interfaces.UpcomingViewModel;

import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class UpcomingListFragment extends Fragment {

    private FragmentUpcomingListBinding binding;
    private UpcomingViewModel upcomingViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUpcomingListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        upcomingViewModel = new ViewModelProvider(requireActivity()).get(FakeUpcomingViewModel.class);
        upcomingViewModel.getUpcomingListUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchinhUpcomingList()) {

                    }
                    else {
                        updateUI(result.getUpcomingList());
                    }
                }
        );
    }

    private void updateUI(List<Upcoming> upcomingList) {
        for (Upcoming upcoming : upcomingList){
            int imageResource = getResources().getIdentifier(upcoming.getBackgroundUri(), null,
                    requireActivity().getPackageName());
            upcoming.setBackgroundImageDrawableResource(imageResource);
        }
        UpcomingAdapter upcomingAdapter = new UpcomingAdapter(upcomingList, getContext(),
                this::navigateToUpdateItemFragment);
        binding.recyclerView.setAdapter(upcomingAdapter);
    }

    private void navigateToUpdateItemFragment(Upcoming upcomingItem) {
        if (upcomingItem.getUpcomingDetail() == null) {
            return;
        }
        upcomingViewModel.setSelectedUpcomingItem(upcomingItem);
        NavDirections action = UpcomingListFragmentDirections
                .actionUpcomingListFragmentToUpcomingDetailFragment();
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}