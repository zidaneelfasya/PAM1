package com.example.projekpam;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CaloriCounterActivity extends AppCompatActivity {

    private Spinner spinnerMakanan;
    private EditText etBerat;
    private Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calori_counter);

        spinnerMakanan = findViewById(R.id.spinnerMakanan);
        etBerat = findViewById(R.id.etBerat);
        btnHitung = findViewById(R.id.btnHitung);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.makanan_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMakanan.setAdapter(adapter);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungNutrisi();
            }
        });
    }

    private void hitungNutrisi() {
        String makanan = spinnerMakanan.getSelectedItem().toString();
        String beratStr = etBerat.getText().toString();

        if (makanan.equals("Pilih Jenis Makanan")) {
            Toast.makeText(this, "Silakan pilih jenis makanan", Toast.LENGTH_SHORT).show();
            return;
        }

        if (beratStr.isEmpty()) {
            Toast.makeText(this, "Silakan masukkan berat makanan", Toast.LENGTH_SHORT).show();
            return;
        }

        int berat = Integer.parseInt(beratStr);

        // Implement your logic to calculate nutrition and calories here
        // For now, let's just show a toast with the input values
        Toast.makeText(this, "Makanan: " + makanan + "\nBerat: " + berat + " Gram", Toast.LENGTH_LONG).show();
    }
}