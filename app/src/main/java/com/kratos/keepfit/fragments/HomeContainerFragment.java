package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.kratos.keepfit.R;
import com.kratos.keepfit.databinding.FragmentHomeContainerBinding;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class HomeContainerFragment extends Fragment {
    
    private FragmentHomeContainerBinding binding;
    private final HomeFragment homeFragment = new HomeFragment();
    private final UserFragment userFragment = new UserFragment();
    private final NotificationListFragment notificationListFragment = new NotificationListFragment();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeContainerBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        requireActivity().getSupportFragmentManager().beginTransaction().replace(
                binding.container.getId(), homeFragment).commit();

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.user_menu_item:
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(
                            binding.container.getId(), userFragment).commit();
                    return true;
                case R.id.notifications_menu_item:
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(
                            binding.container.getId(), notificationListFragment).commit();
                    return true;
                default:
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(
                            binding.container.getId(), homeFragment).commit();
                    return true;
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
