package com.example.projekpam;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class OnboardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_page3);

        // Dapatkan referensi ke tombol
        Button buttonLifestep = findViewById(R.id.button_lifestep);

        // Tetapkan listener untuk menangani klik tombol
        buttonLifestep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mulai LoginActivity
                Log.d("OnboardingActivity", "Button clicked");
                Intent intent = new Intent(OnboardingActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
