package com.kratos.keepfit.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.kratos.keepfit.fragments.FitnessBuddiesAllFragment;
import com.kratos.keepfit.fragments.FitnessBuddiesTopFragment;

public class FitnessBuddiesContainerAdapter extends FragmentStateAdapter {

    public FitnessBuddiesContainerAdapter(Fragment fragment){
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1) {
            return new FitnessBuddiesAllFragment();
        }
        return new FitnessBuddiesTopFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
