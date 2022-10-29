package com.kratos.keepfit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
import com.kratos.keepfit.core.OnItemClickListener;
import com.kratos.keepfit.entities.Allergy;
import java.util.List;

public class AllergyAdapter extends RecyclerView.Adapter<AllergyAdapter.AllergyHolder> {

    private final List<Allergy> allergies;
    private final Context context;
    private final OnItemClickListener<Allergy> onItemClickListener;

    public AllergyAdapter(List<Allergy> allergies, Context context,
                          OnItemClickListener<Allergy> onItemClickListener){
        this.allergies = allergies;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    protected class AllergyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
                                                              
        private final Button allergyButton;
        private Allergy allergy;
        private boolean buttonSelected;


        public AllergyHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            allergyButton = itemView.findViewById(R.id.allergyButton);
            allergyButton.setOnClickListener(this);
        }

        public void bind(Allergy allergy){
            this.allergy = allergy;
            allergyButton.setText(allergy.getName());
            buttonSelected = false;
        }

        @Override
        public void onClick(View view) {

            if (buttonSelected){
                // deselect button
                allergyButton.setBackgroundColor(context.getResources().getColor(R.color.white));
            }
            else {
                // select button
                allergyButton.setBackgroundColor(context.getResources().getColor(R.color.dark_primary));
                onItemClickListener.onItemClick(allergy);
            }

        }
    }

    @NonNull
    @Override
    public AllergyHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_allergy, viewGroup, false);
        return new AllergyHolder(view);
    }

    @Override
    public void onBindViewHolder(AllergyHolder holder, final int position) {
        holder.bind(allergies.get(position));
    }

    @Override
    public int getItemCount() {
        return allergies.size();
    }
}

