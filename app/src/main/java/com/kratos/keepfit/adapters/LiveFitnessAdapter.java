package com.kratos.keepfit.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
import com.kratos.keepfit.core.LiveFitness;

import java.util.List;

public class LiveFitnessAdapter extends RecyclerView.Adapter<LiveFitnessAdapter.LiveFitnessHolder> {

    private final List<LiveFitness> lives;

    public LiveFitnessAdapter(List<LiveFitness> lives){
        this.lives = lives;
    }

    protected static class LiveFitnessHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private View itemView;
        private final TextView nameTextView;
        private final TextView numberOfViews;
        private LiveFitness liveFitness;

        public LiveFitnessHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            itemView.setOnClickListener(this);
            nameTextView = itemView.findViewById(R.id.live_name_text_view);
            numberOfViews = itemView.findViewById(R.id.live_views_number_text_view);
        }

        public void bind(LiveFitness liveFitness){
            this.liveFitness = liveFitness;
            itemView.setBackground(liveFitness.getBackgroundImage());
            nameTextView.setText(liveFitness.getName());
            numberOfViews.setText(liveFitness.getNumberOfViews());
        }

        @Override
        public void onClick(View view) {

        }
    }

    @NonNull
    @Override
    public LiveFitnessHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_live_fitness, viewGroup, false);
        return new LiveFitnessHolder(view);
    }

    @Override
    public void onBindViewHolder(LiveFitnessHolder holder, final int position) {
        holder.bind(lives.get(position));
    }

    @Override
    public int getItemCount() {
        return lives.size();
    }
}