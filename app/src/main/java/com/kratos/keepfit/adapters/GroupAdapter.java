package com.kratos.keepfit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
import com.kratos.keepfit.core.Group;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupHolder> {

    private final List<Group> groups;

    public GroupAdapter(List<Group> groups){
        this.groups = groups;
    }

    protected static class GroupHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView imageIconImageView;
        private final ImageView deleteIconImageView;
        private final TextView groupNameTextView;
        private final TextView statusTextView;
        private final TextView timeTextView;

        private Group group;

        public GroupHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageIconImageView = itemView.findViewById(R.id.group_image_icon);
            deleteIconImageView = itemView.findViewById(R.id.delete_icon);
            groupNameTextView = itemView.findViewById(R.id.group_name_text_view);
            statusTextView = itemView.findViewById(R.id.status_text_view);
            timeTextView = itemView.findViewById(R.id.time_text_view);
        }

        public void bind(Group group){
            this.group = group;
            Picasso.get().load(group.getImageIconDrawableResource()).into(imageIconImageView);
            groupNameTextView.setText(group.getName());
            statusTextView.setText(group.getStatus());
            timeTextView.setText(group.getTime());
        }

        @Override
        public void onClick(View view) {

        }
    }

    @NonNull
    @Override
    public GroupHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_group, viewGroup, false);
        return new GroupHolder(view);
    }

    @Override
    public void onBindViewHolder(GroupHolder holder, final int position) {
        holder.bind(groups.get(position));
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }
}
