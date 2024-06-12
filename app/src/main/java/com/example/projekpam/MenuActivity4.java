package com.example.projekpam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panduan2);


        Button buttonExitGandum = findViewById(R.id.button_exit_gandum);


        // Set onClick listeners for each button
        View.OnClickListener exitListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to BerandaActivity
                Intent intent = new Intent(MenuActivity4.this, MenuutamaActivity.class);
                startActivity(intent);
                finish(); // Close the current activity
            }
        };


        buttonExitGandum.setOnClickListener(exitListener);

    }
}