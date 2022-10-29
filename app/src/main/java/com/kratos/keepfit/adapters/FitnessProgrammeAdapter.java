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
import com.kratos.keepfit.entities.FitnessProgramme;

import java.util.List;

public class FitnessProgrammeAdapter extends RecyclerView.Adapter<FitnessProgrammeAdapter.FitnessProgrammeHolder> {

    private final List<FitnessProgramme> fitnessProgrammes;
    private final OnItemClickListener<FitnessProgramme> onItemClickListener;

    public FitnessProgrammeAdapter(List<FitnessProgramme> fitnessProgrammes, OnItemClickListener<FitnessProgramme> onItemClickListener){
        this.fitnessProgrammes = fitnessProgrammes;
        this.onItemClickListener = onItemClickListener;
    }

    protected class FitnessProgrammeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView titleTextView;
        private final TextView authorTextView;
        private final TextView dateTimeTextView;
        private FitnessProgramme fitnessProgramme;

        public FitnessProgrammeHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            authorTextView = itemView.findViewById(R.id.author_text_view);
            dateTimeTextView = itemView.findViewById(R.id.date_time_text_view);
            Button viewButton = itemView.findViewById(R.id.view_button);
            viewButton.setOnClickListener(this);
        }

        public void bind(FitnessProgramme fitnessProgramme){
            this.fitnessProgramme = fitnessProgramme;
            titleTextView.setText(fitnessProgramme.getTitle());
            authorTextView.setText(fitnessProgramme.getAuthor());
            dateTimeTextView.setText(fitnessProgramme.getDateTime());
        }
 
        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(fitnessProgramme);
        }
    }

    @NonNull
    @Override
    public FitnessProgrammeHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_fitness_programme, viewGroup, false);
        return new FitnessProgrammeHolder(view);
    }

    @Override
    public void onBindViewHolder(FitnessProgrammeHolder holder, final int position) {
        holder.bind(fitnessProgrammes.get(position));
    }

    @Override
    public int getItemCount() {
        return fitnessProgrammes.size();
    }
}