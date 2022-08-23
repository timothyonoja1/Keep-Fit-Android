package com.kratos.keepfit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
import com.kratos.keepfit.core.OnItemClickListener;
import com.kratos.keepfit.entities.Training;
import java.util.List;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.TrainingHolder> {

    private final List<Training> trainings;
    private final OnItemClickListener<Training> onItemClickListener;

    public TrainingAdapter(List<Training> trainings, OnItemClickListener<Training> onItemClickListener){
        this.trainings = trainings;
        this.onItemClickListener = onItemClickListener;
    }

    protected class TrainingHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView titleTextView;
        private final TextView authorTextView;
        private final TextView dateTimeTextView;
        private Training training;

        public TrainingHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            authorTextView = itemView.findViewById(R.id.author_text_view);
            dateTimeTextView = itemView.findViewById(R.id.date_time_text_view);
            Button viewButton = itemView.findViewById(R.id.view_button);
            viewButton.setOnClickListener(this);
        }

        public void bind(Training training){
            this.training = training;
            titleTextView.setText(training.getTitle());
            authorTextView.setText(training.getAuthor());
            dateTimeTextView.setText(training.getDateTime());
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(training);
        }
    }

    @NonNull
    @Override
    public TrainingHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_training, viewGroup, false);
        return new TrainingHolder(view);
    }

    @Override
    public void onBindViewHolder(TrainingHolder holder, final int position) {
        holder.bind(trainings.get(position));
    }

    @Override
    public int getItemCount() {
        return trainings.size();
    }
}