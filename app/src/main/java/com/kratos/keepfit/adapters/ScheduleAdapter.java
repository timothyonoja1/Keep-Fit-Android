package com.kratos.keepfit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
import com.kratos.keepfit.entities.Schedule;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleHolder> {

    private final List<Schedule> schedules;

    public ScheduleAdapter(List<Schedule> schedules){
        this.schedules = schedules;
    }

    protected static class ScheduleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView scheduleTime;
        private final TextView scheduleStatus;
        private Schedule schedule;

        public ScheduleHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            scheduleTime = itemView.findViewById(R.id.schedule_time_text_view);
            scheduleStatus = itemView.findViewById(R.id.schedule_status_text_view);

        }

        public void bind(Schedule schedule){
            this.schedule = schedule;
            scheduleTime.setText(schedule.getTime());
            scheduleStatus.setText(schedule.getScheduleStatus());
        }

        @Override
        public void onClick(View view) {

        }
    }

    @NonNull
    @Override
    public ScheduleHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_schedule, viewGroup, false);
        return new ScheduleHolder(view);
    }

    @Override
    public void onBindViewHolder(ScheduleHolder holder, final int position) {
        holder.bind(schedules.get(position));
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }
}
