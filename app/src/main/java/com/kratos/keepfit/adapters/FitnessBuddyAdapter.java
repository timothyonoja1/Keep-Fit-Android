package com.kratos.keepfit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
import com.kratos.keepfit.core.OnItemClickListener;
import com.kratos.keepfit.entities.UnrelatedFitnessBuddy;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FitnessBuddyAdapter extends RecyclerView.Adapter<FitnessBuddyAdapter.FitnessBuddyHolder> {

    private final List<UnrelatedFitnessBuddy> unrelatedFitnessBuddies;
    private final OnItemClickListener<UnrelatedFitnessBuddy> onImageIconClickListener;
    private final OnItemClickListener<UnrelatedFitnessBuddy> onAddIconClickListener;

    public FitnessBuddyAdapter(List<UnrelatedFitnessBuddy> unrelatedFitnessBuddies,
                               OnItemClickListener<UnrelatedFitnessBuddy> onImageIconClickListener,
                               OnItemClickListener<UnrelatedFitnessBuddy> onItemClickListener){
        this.unrelatedFitnessBuddies = unrelatedFitnessBuddies;
        this.onImageIconClickListener = onImageIconClickListener;
        this.onAddIconClickListener = onItemClickListener;
    }

    protected class FitnessBuddyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView nameTextTextView;
        private final TextView detailsTextView;
        private final ImageView imageView;
        private final ImageView addIconImageView;
        private UnrelatedFitnessBuddy unrelatedFitnessBuddy;

        public FitnessBuddyHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nameTextTextView = itemView.findViewById(R.id.name_text_view);
            detailsTextView = itemView.findViewById(R.id.details_text_view);
            imageView = itemView.findViewById(R.id.image_view);
            imageView.setOnClickListener(clickedImageView -> {
                onImageIconClickListener.onItemClick(unrelatedFitnessBuddy);
            });
            addIconImageView = itemView.findViewById(R.id.add_icon_image_view);
            addIconImageView.setOnClickListener(clickedAddIconImageView -> {
                onAddIconClickListener.onItemClick(unrelatedFitnessBuddy);
            });
        }

        public void bind(UnrelatedFitnessBuddy unrelatedFitnessBuddy){
            this.unrelatedFitnessBuddy = unrelatedFitnessBuddy;
            nameTextTextView.setText(unrelatedFitnessBuddy.getName());
            detailsTextView.setText(unrelatedFitnessBuddy.getDescription());
            Picasso.get().load(unrelatedFitnessBuddy.getDrawableResource()).into(imageView);
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
        holder.bind(unrelatedFitnessBuddies.get(position));
    }

    @Override
    public int getItemCount() {
        return unrelatedFitnessBuddies.size();
    }
}