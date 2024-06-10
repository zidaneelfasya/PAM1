package com.example.projekpam;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class JadwalWorkoutActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private WorkoutAdapter workoutAdapter;
    private List<Workout> workoutList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jadwal_workout);

        recyclerView = findViewById(R.id.rv_workouts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create dummy data for demonstration purposes
        workoutList = new ArrayList<>();
        workoutList.add(new Workout("Lunges", "x10", R.drawable.ic_lunges));

        workoutAdapter = new WorkoutAdapter(workoutList);
        recyclerView.setAdapter(workoutAdapter);
    }
}
