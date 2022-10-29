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
import com.kratos.keepfit.entities.SkillLevel;
import java.util.List;

public class SkillLevelAdapter extends RecyclerView.Adapter<SkillLevelAdapter.SkillLevelHolder> {

    private final List<SkillLevel> skillLevels;
    private final OnItemClickListener<SkillLevel> onItemClickListener;

    public SkillLevelAdapter(List<SkillLevel> skillLevels,
                             OnItemClickListener<SkillLevel> onItemClickListener){
        this.skillLevels = skillLevels;
        this.onItemClickListener = onItemClickListener;
    }

    protected class SkillLevelHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView nameTextView;
        private SkillLevel skillLevel;

        public SkillLevelHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_text_view);
            RadioButton radioButton = itemView.findViewById(R.id.radio_button);
            radioButton.setOnClickListener(this);
        }

        public void bind(SkillLevel skillLevel){
            this.skillLevel = skillLevel;
            nameTextView.setText(skillLevel.getName());
        }

        @Override
        public void onClick(View view) {
            boolean checked = ((RadioButton) view).isChecked();
            if (checked) {
                onItemClickListener.onItemClick(skillLevel);
            }
        }
    }

    @NonNull
    @Override
    public SkillLevelAdapter.SkillLevelHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_skill_level, viewGroup, false);
        return new SkillLevelAdapter.SkillLevelHolder(view);
    }

    @Override
    public void onBindViewHolder(SkillLevelAdapter.SkillLevelHolder holder, final int position) {
        holder.bind(skillLevels.get(position));
    }

    @Override
    public int getItemCount() {
        return skillLevels.size();
    }
}