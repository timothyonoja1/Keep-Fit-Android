package com.kratos.keepfit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
import com.kratos.keepfit.core.OnItemClickListener;
import com.kratos.keepfit.entities.Upcoming;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.UpcomingHolder> {

    private final List<Upcoming> upcomingList;
    private final Context context;
    private final OnItemClickListener<Upcoming> onItemClickListener;

    public UpcomingAdapter(List<Upcoming> upcomingList, Context context,
                              OnItemClickListener<Upcoming> onItemClickListener){
        this.upcomingList = upcomingList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    protected class UpcomingHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private View itemView;
        private final TextView nameTextView;
        private final TextView numberOfBookings;
        private Upcoming upcoming;

        public UpcomingHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            itemView.setOnClickListener(this);
            nameTextView = itemView.findViewById(R.id.name_text_view);
            numberOfBookings = itemView.findViewById(R.id.bookings_number_text_view);
        }

        public void bind(Upcoming upcoming){
            this.upcoming = upcoming;
            nameTextView.setText(upcoming.getName());
            numberOfBookings.setText(upcoming.getNumberOfBookings());
            ImageView img = new ImageView(context);
            Picasso.get().load(upcoming.getBackgroundImageDrawableResource()).into(img, new Callback() {
                @Override
                public void onSuccess() {
                    itemView.setBackground(img.getDrawable());
                }

                @Override
                public void onError(Exception e) {

                }
            });
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(upcoming);
        }
    }

    @NonNull
    @Override
    public UpcomingHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_upcoming, viewGroup, false);
        return new UpcomingHolder(view);
    }

    @Override
    public void onBindViewHolder(UpcomingHolder holder, final int position) {
        holder.bind(upcomingList.get(position));
    }

    @Override
    public int getItemCount() {
        return upcomingList.size();
    }
}
