package com.example.projekpam;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class WorkoutSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_selection);

        // Inisialisasi tombol setelah layout diatur
        Button btnDailyWorkout = findViewById(R.id.btn_daily_workout);
        Button btnhiitWorkout = findViewById(R.id.btn_hiit_workout);
        Button btnSenamWorkout = findViewById(R.id.btn_senam_workout);

        // Set onClickListener untuk tombol
        btnhiitWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk memulai JadwalWorkoutActivity
                Intent intent = new Intent(WorkoutSelectionActivity.this, WorkoutHiitActivity.class);
                startActivity(intent);
            }
        });
        btnDailyWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk memulai JadwalWorkoutActivity
                Intent intent = new Intent(WorkoutSelectionActivity.this, JadwalWorkoutActivity.class);
                startActivity(intent);
            }
        });
        btnSenamWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk memulai JadwalWorkoutActivity
                Intent intent = new Intent(WorkoutSelectionActivity.this, SenamActivity.class);
                startActivity(intent);
            }
        });
    }
}
