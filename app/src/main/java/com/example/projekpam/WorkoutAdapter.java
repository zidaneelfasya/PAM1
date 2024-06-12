package com.example.projekpam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {
    private List<Workout> workoutList;

    public WorkoutAdapter(List<Workout> workoutList) {
        this.workoutList = workoutList;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_workout, parent, false);
        return new WorkoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        Workout workout = workoutList.get(position);
        holder.tvWorkoutName.setText(workout.getName());
        holder.tvWorkoutReps.setText(workout.getReps());
        holder.imgWorkout.setImageResource(workout.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    public static class WorkoutViewHolder extends RecyclerView.ViewHolder {
        ImageView imgWorkout;
        TextView tvWorkoutName;
        TextView tvWorkoutReps;

        public WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);
            imgWorkout = itemView.findViewById(R.id.img_workout);
            tvWorkoutName = itemView.findViewById(R.id.editTextTitle);
            tvWorkoutReps = itemView.findViewById(R.id.editTextDescription);
        }
    }
}
