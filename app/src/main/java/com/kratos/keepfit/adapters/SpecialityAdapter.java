package com.kratos.keepfit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kratos.keepfit.R;
import com.kratos.keepfit.core.Speciality;

import java.util.List;

public class SpecialityAdapter extends RecyclerView.Adapter<SpecialityAdapter.SpecialityHolder> {

    private final List<Speciality> specialities;

    public SpecialityAdapter(List<Speciality> specialities){
        this.specialities = specialities;
    }

    protected static class SpecialityHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView specialityName;
        private Speciality speciality;

        public SpecialityHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            specialityName = itemView.findViewById(R.id.speciality_name);
        }

        public void bind(Speciality speciality){
            this.speciality = speciality;
            specialityName.setText(speciality.getName());
        }

        @Override
        public void onClick(View view) {

        }
    }

    @NonNull
    @Override
    public SpecialityHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_speciality, viewGroup, false);
        return new SpecialityHolder(view);
    }

    @Override
    public void onBindViewHolder(SpecialityHolder holder, final int position) {
        holder.bind(specialities.get(position));
    }

    @Override
    public int getItemCount() {
        return specialities.size();
    }
}