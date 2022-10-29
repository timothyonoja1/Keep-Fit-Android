package com.kratos.keepfit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
import com.kratos.keepfit.core.OnItemClickListener;
import com.kratos.keepfit.entities.FitnessGoal;
import java.util.List;

public class FitnessGoalAdapter extends RecyclerView.Adapter<FitnessGoalAdapter.FitnessGoalHolder> {

    private final List<FitnessGoal> fitnessGoals;
    private final OnItemClickListener<FitnessGoal> onItemClickListener;

    public FitnessGoalAdapter(List<FitnessGoal> fitnessGoals, OnItemClickListener<FitnessGoal> onItemClickListener){
        this.fitnessGoals = fitnessGoals;
        this.onItemClickListener = onItemClickListener;
    }

    protected class FitnessGoalHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView nameTextView;
        private final CheckBox checkBox;
        private FitnessGoal fitnessGoal;
        private boolean previousChecked;

        public FitnessGoalHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_text_view);
            checkBox = itemView.findViewById(R.id.checkbox_button);
            checkBox.setOnClickListener(this);
        }

        public void bind(FitnessGoal fitnessGoal){
            this.fitnessGoal = fitnessGoal;
            nameTextView.setText(fitnessGoal.getName());
        }

        @Override
        public void onClick(View view) {
            boolean checked = ((CheckBox) view).isChecked();
            if (checked) {
                onItemClickListener.onItemClick(fitnessGoal);
            }
        }
    }

    @NonNull
    @Override
    public FitnessGoalHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_fitness_goal, viewGroup, false);
        return new FitnessGoalHolder(view);
    }

    @Override
    public void onBindViewHolder(FitnessGoalHolder holder, final int position) {
        holder.bind(fitnessGoals.get(position));
    }

    @Override
    public int getItemCount() {
        return fitnessGoals.size();
    }
}
