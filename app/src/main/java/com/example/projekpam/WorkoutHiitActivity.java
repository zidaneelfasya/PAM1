package com.example.projekpam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class WorkoutHiitActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private WorkoutAdapter HiitAdapter;
    private List<Workout> HiitList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_hiit);
        recyclerView = findViewById(R.id.rv_hiit);
        recyclerView.setLayoutManager(new LinearLayoutManager(WorkoutHiitActivity.this));

        // Create dummy data for demonstration purposes
        HiitList = new ArrayList<>();
        HiitList.add(new Workout("Run in place", "x20", R.drawable.lari_ditempat));
        HiitList.add(new Workout("Cross Jacks", "x10", R.drawable.cross_jacks));
        HiitList.add(new Workout("Butt Kick", "x15", R.drawable.butt_kick));
        HiitList.add(new Workout("Cross Climbers", "x10", R.drawable.cross_climbers));

        // Set the adapter for the RecyclerView
        HiitAdapter = new WorkoutAdapter(HiitList);
        recyclerView.setAdapter(HiitAdapter);
    }
}