package com.kratos.keepfit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kratos.keepfit.R;
import com.kratos.keepfit.core.Notification;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationHolder> {

    private final List<Notification> notifications;

    public NotificationAdapter(List<Notification> notifications){
        this.notifications = notifications;
    }

    protected static class NotificationHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView notificationTextTextView;
        private final TextView notificationTimeTextView;
        private final ImageView notificationImage;
        private Notification notification;

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
            Picasso.get().load(notification.getDrawableResource()).into(notificationImage);
        }

        @Override
        public void onClick(View view) {

        }
    }

    @NonNull
    @Override
    public NotificationHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_notification, viewGroup, false);
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
