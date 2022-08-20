package com.kratos.keepfit.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
import com.kratos.keepfit.core.Exercise;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseHolder> {

    private final List<Exercise> exercises;
    private final Context context;

    public ExerciseAdapter(List<Exercise> exercises, Context context){
        this.exercises = exercises;
        this.context = context;
    }

    protected class ExerciseHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final View itemView;
        private final ImageView favoriteIcon;
        private final ImageView checkIcon;
        private final ImageView headlineIcon;
        private final ImageView forwardIcon;
        private final ImageView adjustIcon;
        private final ImageView personAddIcon;
        private final ImageView contaclessIcon;
        private final TextView nameTextView;
        private final TextView detailsTextView;

        private Exercise exercise;

        public ExerciseHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.itemView = itemView;
            favoriteIcon = itemView.findViewById(R.id.favorite_icon);
            checkIcon = itemView.findViewById(R.id.check_icon);
            headlineIcon = itemView.findViewById(R.id.headline_icon);
            forwardIcon = itemView.findViewById(R.id.forward_icon);
            adjustIcon = itemView.findViewById(R.id.adjust_icon);
            personAddIcon = itemView.findViewById(R.id.person_add_icon);
            contaclessIcon = itemView.findViewById(R.id.contactless_icon);
            nameTextView = itemView.findViewById(R.id.name_text_view);
            detailsTextView = itemView.findViewById(R.id.details_text_view);
        }

        public void bind(Exercise exercise){
            this.exercise = exercise;
            ImageView img = new ImageView(context);
            Picasso.get().load(exercise.getDrawableResource()).into(img, new Callback() {
                @Override
                public void onSuccess() {
                    itemView.setBackground(img.getDrawable());
                }

                @Override
                public void onError(Exception e) {

                }
            });
        }

        @Override
        public void onClick(View view) {

        }
    }

    @NonNull
    @Override
    public ExerciseHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_exercise, viewGroup, false);
        return new ExerciseHolder(view);
    }

    @Override
    public void onBindViewHolder(ExerciseHolder holder, final int position) {
        holder.bind(exercises.get(position));
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }
}