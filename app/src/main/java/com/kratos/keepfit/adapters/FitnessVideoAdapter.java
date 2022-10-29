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
import com.kratos.keepfit.entities.FitnessProgramme;
import com.kratos.keepfit.entities.FitnessVideo;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.List;

public class FitnessVideoAdapter extends RecyclerView.Adapter<FitnessVideoAdapter.FitnessVideoHolder> {

    private final List<FitnessVideo> fitnessVideos;
    private final OnItemClickListener<FitnessVideo> onItemClickListener;
    private final Context context;

    public FitnessVideoAdapter(List<FitnessVideo> fitnessVideos,
                               OnItemClickListener<FitnessVideo> onItemClickListener,
                               Context context){
        this.fitnessVideos = fitnessVideos;
        this.onItemClickListener = onItemClickListener;
        this.context = context;
    }

    protected class FitnessVideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final View itemView;
        private final ImageView favoriteIcon;
        private final TextView imageTextView;
        private final TextView titleTextView;
        private final TextView descriptionTextView;

        private FitnessVideo fitnessVideo;

        public FitnessVideoHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.itemView = itemView;
            favoriteIcon = itemView.findViewById(R.id.favorite_icon);
            imageTextView = itemView.findViewById(R.id.image_text_view);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            descriptionTextView = itemView.findViewById(R.id.description_text_view);
        }

        public void bind(FitnessVideo fitnessVideo){
            this.fitnessVideo = fitnessVideo;
            titleTextView.setText(fitnessVideo.getTitle());
            descriptionTextView.setText(fitnessVideo.getDescription());
            if (fitnessVideo.isFavorite()){
                favoriteIcon.setImageResource(R.drawable.ic_baseline_favorite_24_colored);
            }
            else {
                favoriteIcon.setImageResource(R.drawable.ic_outline_favorite_border_24);
            }
            ImageView img = new ImageView(context);
            Picasso.get().load(fitnessVideo.getDrawableResource()).into(img, new Callback() {
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
            onItemClickListener.onItemClick(fitnessVideo);
        }
    }

    @NonNull
    @Override
    public FitnessVideoHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_fitness_video, viewGroup, false);
        return new FitnessVideoHolder(view);
    }

    @Override
    public void onBindViewHolder(FitnessVideoHolder holder, final int position) {
        holder.bind(fitnessVideos.get(position));
    }

    @Override
    public int getItemCount() {
        return fitnessVideos.size();
    }
}