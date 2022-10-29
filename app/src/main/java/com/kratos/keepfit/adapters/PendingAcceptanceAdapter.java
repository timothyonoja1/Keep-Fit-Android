package com.kratos.keepfit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
import com.kratos.keepfit.core.OnItemClickListener;
import com.kratos.keepfit.entities.UnrelatedFitnessBuddy;

import java.util.List;

public class PendingAcceptanceAdapter extends RecyclerView.Adapter<PendingAcceptanceAdapter.PendingAcceptanceHolder> {

    private final List<UnrelatedFitnessBuddy> pendingAcceptances;
    private final OnItemClickListener<UnrelatedFitnessBuddy> onItemClickListener;

    public PendingAcceptanceAdapter(List<UnrelatedFitnessBuddy> pendingAcceptances,
                                    OnItemClickListener<UnrelatedFitnessBuddy> onItemClickListener){
        this.pendingAcceptances = pendingAcceptances;
        this.onItemClickListener = onItemClickListener;
    }

    protected class PendingAcceptanceHolder extends RecyclerView.ViewHolder {

        private final TextView nameTextView;
        private UnrelatedFitnessBuddy pendingAcceptance;

        public PendingAcceptanceHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(clickedView -> {
                onItemClickListener.onItemClick(pendingAcceptance);
            });
            nameTextView = itemView.findViewById(R.id.name_text_view);
        }

        public void bind(UnrelatedFitnessBuddy pendingAcceptance){
            this.pendingAcceptance = pendingAcceptance;
            nameTextView.setText(pendingAcceptance.getName());
        }
    }

    @NonNull
    @Override
    public PendingAcceptanceHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_pending_acceptance, viewGroup, false);
        return new PendingAcceptanceHolder(view);
    }

    @Override
    public void onBindViewHolder(PendingAcceptanceHolder holder, final int position) {
        holder.bind(pendingAcceptances.get(position));
    }

    @Override
    public int getItemCount() {
        return pendingAcceptances.size();
    }
}
