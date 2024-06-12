package com.example.projekpam;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    private TextView stepsTextView;
    private TextView stepsLabelTextView;
    private TextView timeTextView;
    private TextView timeLabelTextView;
    private TextView caloriesTextView;
    private TextView distanceTextView;
    private TextView heartRateTextView;
    private ImageView icBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        // Initialize the TextViews
        stepsTextView = findViewById(R.id.stepsTextView);
        stepsLabelTextView = findViewById(R.id.stepsLabelTextView);
        timeTextView = findViewById(R.id.timeTextView);
        timeLabelTextView = findViewById(R.id.timeLabelTextView);
        caloriesTextView = findViewById(R.id.caloriesTextView);
        distanceTextView = findViewById(R.id.distanceTextView);
        heartRateTextView = findViewById(R.id.heartRateTextView);
        icBack = findViewById(R.id.icBack);
        // Set static data
        stepsTextView.setText("9,187");
        stepsLabelTextView.setText("steps");
        timeTextView.setText("37");
        timeLabelTextView.setText("min");
        caloriesTextView.setText("457 kcal");
        distanceTextView.setText("7.26 km");
        heartRateTextView.setText("89 bpm");
        icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kembali ke halaman sebelumnya
                finish();
            }
        });
    }
}
