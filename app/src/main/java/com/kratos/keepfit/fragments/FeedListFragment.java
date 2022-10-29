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
import com.kratos.keepfit.R;
import com.kratos.keepfit.adapters.FeedAdapter;
import com.kratos.keepfit.databinding.FragmentFeedListBinding;
import com.kratos.keepfit.entities.Feed;
import com.kratos.keepfit.states.FeedListUiState;
import com.kratos.keepfit.viewmodels.interfaces.FeedViewModel;
import com.kratos.keepfit.viewmodels.real.FeedViewModelImpl;
import com.squareup.picasso.Picasso;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class FeedListFragment extends Fragment {

    private FragmentFeedListBinding binding;
    private FeedViewModel feedViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFeedListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.profilePic.setOnClickListener(imageView -> {
            NavDirections action = FeedListFragmentDirections
                    .actionFeedListFragmentToAccountFragment();
            Navigation.findNavController(imageView).navigate(action);
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        feedViewModel = new ViewModelProvider(requireActivity()).get(FeedViewModelImpl.class);
        feedViewModel.getFeedListUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingFeedList()) {

                    }
                    else {
                        updateUI(result);
                    }
                }
        );
    }

    private void updateUI(FeedListUiState feedListUiState) {
        binding.greetingTextView.setText(feedListUiState.getAppropriateGreeting());
        binding.firstNameTextView.setText(feedListUiState.getUserProfile().getFirstname());
        binding.numberOfSessionsTextView.setText(
                String.format("\t %s \n Sessions", feedListUiState.getUserProfileDetail().getNumberOfSessions())
        );

        Picasso.get().load(feedListUiState.getUserProfileDetail().getImageUri())
                .placeholder(R.drawable.grey_background).error(R.drawable.grey_background)
                .into(binding.profilePic);

        for (Feed feed : feedListUiState.getFeeds()) {
            int imageResource = getResources().getIdentifier(feed.getImageUrl(),
                    null, requireActivity().getPackageName());
            feed.setDrawableResource(imageResource);
        }
        FeedAdapter feedAdapter = new FeedAdapter(feedListUiState.getFeeds(), requireContext());
        binding.recyclerView.setAdapter(feedAdapter);

        if (feedListUiState.getFeeds().isEmpty()) {
            binding.recyclerView.setVisibility(View.GONE);
            binding.noFeedsTextView.setVisibility(View.VISIBLE);
        }
        else {
            binding.recyclerView.setVisibility(View.VISIBLE);
            binding.noFeedsTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}