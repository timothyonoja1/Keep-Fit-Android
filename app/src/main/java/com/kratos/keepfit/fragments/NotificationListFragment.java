package com.kratos.keepfit.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kratos.keepfit.adapters.NotificationAdapter;
import com.kratos.keepfit.core.Notification;
import com.kratos.keepfit.databinding.FragmentNotificationListBinding;
import java.util.ArrayList;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class NotificationListFragment extends Fragment {

    private FragmentNotificationListBinding binding;
    private List<Notification> notifications;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        notifications = new ArrayList<>();
        binding = FragmentNotificationListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        List<String> uris = new ArrayList<>();
        uris.add("@drawable/tania_dp");
        uris.add("@drawable/leon_small_dp");
        uris.add("@drawable/tania_dp");
        uris.add("@drawable/tania_dp");
        uris.add("@drawable/adeola_dp");
        uris.add("@drawable/ic_baseline_star_24");

        List<String> notificationText = new ArrayList<>();
        notificationText.add("Tonia Hardy Posted 2 new Pics ");
        notificationText.add("Pure Gym Hackney has left some feedback on your profile");
        notificationText.add("Tonia Hardy licked your workout, Circuit Training Fundamentals");
        notificationText.add("Tonia Hardy confirmed your buddy request");
        notificationText.add("Adeola comfirmed your buddy request");
        notificationText.add("WELL DONE! You have completed 20 minutes of Circuit Training Fundamentals");

        List<String> dates = new ArrayList<>();
        dates.add("10:00 PM");
        dates.add("9:00 PM");
        dates.add("Yesterday");
        dates.add("Tuesday");
        dates.add("Monday");
        dates.add("Monday");

        int i = 0;
        while (i < 6) {
            int imageResource = getResources().getIdentifier(uris.get(i), null, requireActivity().getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            notifications.add(new Notification(1, notificationText.get(i), "", dates.get(i), res));
            ++i;
        }

        updateUI();
    }

    private void updateUI(){
        NotificationAdapter notificationAdapter = new NotificationAdapter(notifications);
        binding.recyclerView.setAdapter(notificationAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}