package com.kratos.keepfit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
import com.kratos.keepfit.core.FitnessBuddy;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FitnessBuddyAdapter extends RecyclerView.Adapter<FitnessBuddyAdapter.FitnessBuddyHolder> {

    private final List<FitnessBuddy> fitnessBuddies;

    public FitnessBuddyAdapter(List<FitnessBuddy> fitnessBuddies){
        this.fitnessBuddies = fitnessBuddies;
    }

    protected static class FitnessBuddyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView nameTextTextView;
        private final TextView detailsTextView;
        private final ImageView imageView;
        private FitnessBuddy fitnessBuddy;

        public FitnessBuddyHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nameTextTextView = itemView.findViewById(R.id.name_text_view);
            detailsTextView = itemView.findViewById(R.id.details_text_view);
            imageView = itemView.findViewById(R.id.image_view);

        }

        public void bind(FitnessBuddy fitnessBuddy){
            this.fitnessBuddy = fitnessBuddy;
            nameTextTextView.setText(fitnessBuddy.getName());
            detailsTextView.setText(fitnessBuddy.getDescription());
            Picasso.get().load(fitnessBuddy.getDrawableResource()).into(imageView);
        }

        @Override
        public void onClick(View view) {

        }
    }

    @NonNull
    @Override
    public FitnessBuddyHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_fitness_buddy, viewGroup, false);
        return new FitnessBuddyHolder(view);
    }

    @Override
    public void onBindViewHolder(FitnessBuddyHolder holder, final int position) {
        holder.bind(fitnessBuddies.get(position));
    }

    @Override
    public int getItemCount() {
        return fitnessBuddies.size();
    }
}