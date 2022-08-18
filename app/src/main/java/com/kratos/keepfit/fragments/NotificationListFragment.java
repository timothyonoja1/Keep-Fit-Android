package com.kratos.keepfit.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
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
        String uri = "@drawable/anthony";

        int imageResource = getResources().getIdentifier(uri, null, requireActivity().getPackageName());
        Drawable res = getResources().getDrawable(imageResource);

        notifications.add(new Notification(1, "Tonia Hardy Posted 2 new Pics",
                "", "10:00 PM", res));
        notifications.add(new Notification(2, "Pure Gym Hackney has left some feedback on your profile",
                "", "9:00 PM", res));
        notifications.add(new Notification(3, "Tonia Hardy licked your workout, Circuit Training Fundamentals",
                "", "Yesterday", res));
        notifications.add(new Notification(4, "Tonia Hardy comfirmed your buddy request",
                "", "Tuesday", res));
        notifications.add(new Notification(5, "Adeola comfirmed your buddy request",
                "", "Monday", res));
        notifications.add(new Notification(6, "WELL DONE! You have completed 20 minutes of Circuit Training Fundamentals",
                "", "Monday", res));
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