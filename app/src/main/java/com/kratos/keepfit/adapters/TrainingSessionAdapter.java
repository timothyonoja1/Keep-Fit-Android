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
import com.kratos.keepfit.entities.TrainingSession;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.List;

public class TrainingSessionAdapter extends RecyclerView.Adapter<TrainingSessionAdapter.TrainingSessionHolder> {

    private final List<TrainingSession> trainingSessions;
    private final Context context;

    public TrainingSessionAdapter(List<TrainingSession> trainingSessions, Context context){
        this.trainingSessions = trainingSessions;
        this.context = context;
    }

    protected class TrainingSessionHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final View itemView;
        private final ImageView favoriteIcon;
        private final TextView imageTextView;
        private final TextView titleTextView;
        private final TextView descriptionTextView;

        private TrainingSession trainingSession;

        public TrainingSessionHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.itemView = itemView;
            favoriteIcon = itemView.findViewById(R.id.favorite_icon);
            imageTextView = itemView.findViewById(R.id.image_text_view);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            descriptionTextView = itemView.findViewById(R.id.description_text_view);
        }

        public void bind(TrainingSession trainingSession){
            this.trainingSession = trainingSession;
            titleTextView.setText(trainingSession.getTitle());
            descriptionTextView.setText(trainingSession.getDescription());
            if (trainingSession.isFavorite()){
                favoriteIcon.setImageResource(R.drawable.ic_baseline_favorite_24_colored);
            }
            else {
                favoriteIcon.setImageResource(R.drawable.ic_outline_favorite_border_24);
            }
            ImageView img = new ImageView(context);
            Picasso.get().load(trainingSession.getDrawableResource()).into(img, new Callback() {
                @Override
                public void onSuccess() {
                    imageTextView.setBackground(img.getDrawable());
                }

                @Override
                public void onError(Exception e) {

                }
            });
        }

        @Override
        public void onClick(View view) {

        }
    }

    @NonNull
    @Override
    public TrainingSessionHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_training_session, viewGroup, false);
        return new TrainingSessionHolder(view);
    }

    @Override
    public void onBindViewHolder(TrainingSessionHolder holder, final int position) {
        holder.bind(trainingSessions.get(position));
    }

    @Override
    public int getItemCount() {
        return trainingSessions.size();
    }
}