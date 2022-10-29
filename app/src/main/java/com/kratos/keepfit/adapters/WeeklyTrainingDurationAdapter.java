package com.kratos.keepfit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
import com.kratos.keepfit.core.OnItemClickListener;
import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import java.util.List;

public class WeeklyTrainingDurationAdapter extends RecyclerView.Adapter<WeeklyTrainingDurationAdapter.WeeklyTrainingDurationHolder> {

    private final List<WeeklyTrainingDuration> weeklyTrainingDurations;
    private final OnItemClickListener<WeeklyTrainingDuration> onItemClickListener;

    public WeeklyTrainingDurationAdapter(List<WeeklyTrainingDuration> weeklyTrainingDurations,
                                         OnItemClickListener<WeeklyTrainingDuration> onItemClickListener){
        this.weeklyTrainingDurations = weeklyTrainingDurations;
        this.onItemClickListener = onItemClickListener;
    }

    protected class WeeklyTrainingDurationHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView nameTextView;
        private WeeklyTrainingDuration weeklyTrainingDuration;

        public WeeklyTrainingDurationHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_text_view);
            RadioButton radioButton = itemView.findViewById(R.id.radio_button);
            radioButton.setOnClickListener(this);
        }

        public void bind(WeeklyTrainingDuration weeklyTrainingDuration){
            this.weeklyTrainingDuration = weeklyTrainingDuration;
            nameTextView.setText(weeklyTrainingDuration.getDescription());
        }

        @Override
        public void onClick(View view) {
            boolean checked = ((RadioButton) view).isChecked();
            if (checked) {
                onItemClickListener.onItemClick(weeklyTrainingDuration);
            }
        }
    }

    @NonNull
    @Override
    public WeeklyTrainingDurationHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_weekly_training_duration, viewGroup, false);
        return new WeeklyTrainingDurationHolder(view);
    }

    @Override
    public void onBindViewHolder(WeeklyTrainingDurationHolder holder, final int position) {
        holder.bind(weeklyTrainingDurations.get(position));
    }

    @Override
    public int getItemCount() {
        return weeklyTrainingDurations.size();
    }
}

