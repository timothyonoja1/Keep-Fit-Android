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
import com.kratos.keepfit.core.Notification;
import com.kratos.keepfit.databinding.FragmentNotificationListBinding;
import com.kratos.keepfit.databinding.NotificationListItemBinding;
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
        Notification notification = new Notification(
                1, "Tonia Hardy Posted 2 new Pics", "", "10:00 PM", res);
        int i = 1;
        while (i < 8){
            notifications.add(notification);
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

    private class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationHolder> {

        private final List<Notification> notifications;

        public NotificationAdapter(List<Notification> notifications){
            this.notifications = notifications;
        }

        private class NotificationHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private final TextView notificationTextTextView;
            private final TextView notificationTimeTextView;
            private final ImageView notificationImage;
            private Notification notification;
            private NotificationListItemBinding itemBinding;

            public NotificationHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);
                notificationTextTextView = itemView.findViewById(R.id.notification_text);
                notificationTimeTextView = itemView.findViewById(R.id.notification_time);
                notificationImage = itemView.findViewById(R.id.notification_image);
            }

            public void bind(Notification notification){
                this.notification = notification;
                notificationTextTextView.setText(notification.getDisplayText());
                notificationTimeTextView.setText(notification.getPostedDate());
                notificationImage.setImageDrawable(notification.getDrawableResource());
            }

            @Override
            public void onClick(View view) {

            }
        }

        @NonNull
        @Override
        public NotificationHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.notification_list_item, viewGroup, false);
            return new NotificationHolder(view);
        }

        @Override
        public void onBindViewHolder(NotificationHolder holder, final int position) {
            holder.bind(notifications.get(position));
        }

        @Override
        public int getItemCount() {
            return notifications.size();
        }
    }
}
