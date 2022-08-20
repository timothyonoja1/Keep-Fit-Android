package com.kratos.keepfit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
import java.util.List;

public class PendingAcceptanceAdapter extends RecyclerView.Adapter<PendingAcceptanceAdapter.PendingAcceptanceHolder> {

    private final List<String> pendingAcceptances;

    public PendingAcceptanceAdapter(List<String> pendingAcceptances){
        this.pendingAcceptances = pendingAcceptances;
    }

    protected static class PendingAcceptanceHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView nameTextView;
        private String pendingAcceptanceName;

        public PendingAcceptanceHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nameTextView = itemView.findViewById(R.id.name_text_view);
        }

        public void bind(String pendingAcceptanceName){
            this.pendingAcceptanceName = pendingAcceptanceName;
            nameTextView.setText(pendingAcceptanceName);
        }

        @Override
        public void onClick(View view) {

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
