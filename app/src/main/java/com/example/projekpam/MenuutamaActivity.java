package com.example.projekpam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuutamaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuutama);

        // Find the exit button by ID
        Button buttonExitUtama = findViewById(R.id.button_exit_utama);

        // Set an onClick listener for the exit button
        buttonExitUtama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to BerandaActivity
                Intent intent = new Intent(MenuutamaActivity.this, BerandaActivity.class);
                startActivity(intent);
                finish(); // Close the current activity
            }
        });

        // Find the other buttons by ID
        Button buttonToRecipeScreen = findViewById(R.id.button_to_recipe_screen);
        Button buttonToOtherScreen = findViewById(R.id.button_to_other_screen);
        Button buttonToPanduanGandum = findViewById(R.id.r4);
        Button buttonToPanduanProtein = findViewById(R.id.r5);

        // Set an onClick listener for the button to recipe screen
        buttonToRecipeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to ResepAyamPanggangActivity
                Intent intent = new Intent(MenuutamaActivity.this, MenuActivity1.class);
                startActivity(intent);
            }
        });

        // Set an onClick listener for the button to other screen
        buttonToOtherScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to ResepSmoothieHijauActivity
                Intent intent = new Intent(MenuutamaActivity.this, MenuActivity2.class);
                startActivity(intent);
            }
        });

        // Set an onClick listener for the button to Panduan Gandum
        buttonToPanduanGandum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to PanduanGandumActivity
                Intent intent = new Intent(MenuutamaActivity.this, MenuActivity4.class);
                startActivity(intent);
            }
        });

        // Set an onClick listener for the button to Panduan Protein
        buttonToPanduanProtein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to PanduanProteinActivity
                Intent intent = new Intent(MenuutamaActivity.this, MenuActivity3.class);
                startActivity(intent);
            }
        });
    }
}
