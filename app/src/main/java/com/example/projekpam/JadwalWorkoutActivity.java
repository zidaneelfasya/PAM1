package com.example.projekpam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        recyclerView.setLayoutManager(new LinearLayoutManager(JadwalWorkoutActivity.this));

        // Create dummy data for demonstration purposes
        workoutList = new ArrayList<>();
        workoutList.add(new Workout("Loncat Bintang", "x20", R.drawable.loncatori));
        workoutList.add(new Workout("Push Up", "x10", R.drawable.pushupori));
        workoutList.add(new Workout("Squat", "x15", R.drawable.squatorii));
        workoutList.add(new Workout("Menekuk Lutut", "x10", R.drawable.lungess));
        workoutList.add(new Workout("Peregangan Dada", "tahan sampai 30-50 detik", R.drawable.peregangan_dadaori));

        // Set the adapter for the RecyclerView
        workoutAdapter = new WorkoutAdapter(workoutList);
        recyclerView.setAdapter(workoutAdapter);



        // Set an onClick listener for the back button



    }
}
