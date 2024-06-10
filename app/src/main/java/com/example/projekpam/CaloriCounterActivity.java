package com.example.projekpam;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaloriCounterActivity extends AppCompatActivity {

    private Spinner spinnerMakanan;
    private EditText etBerat;
    private Button btnHitung;
    private TextView textViewHasil;
    private DatabaseReference mDatabase;
    private Map<String, Double> makananKaloriMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calori_counter);
        FirebaseApp.initializeApp(this);


        spinnerMakanan = findViewById(R.id.spinnerMakanan);
        etBerat = findViewById(R.id.etBerat);
        btnHitung = findViewById(R.id.btnHitung);
        textViewHasil = findViewById(R.id.textViewHasil);
        mDatabase = FirebaseDatabase.getInstance().getReference("Makanan");

        makananKaloriMap = new HashMap<>();

        // Ambil data makanan dari Firebase
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> makananList = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String nama = snapshot.child("nama").getValue(String.class);
                    Double kalori = snapshot.child("kalori").getValue(Double.class);
                    if (nama != null && kalori != null) {
                        makananList.add(nama);
                        makananKaloriMap.put(nama, kalori);
                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(CaloriCounterActivity.this,
                        android.R.layout.simple_spinner_item, makananList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerMakanan.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(CaloriCounterActivity.this, "Gagal mengambil data makanan", Toast.LENGTH_SHORT).show();
            }
        });

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

        if (makanan.isEmpty()) {
            Toast.makeText(this, "Silakan pilih jenis makanan", Toast.LENGTH_SHORT).show();
            return;
        }

        if (beratStr.isEmpty()) {
            Toast.makeText(this, "Silakan masukkan berat makanan", Toast.LENGTH_SHORT).show();
            return;
        }

        int berat = Integer.parseInt(beratStr);

        Double kaloriPerGram = makananKaloriMap.get(makanan);
        if (kaloriPerGram != null) {
            double totalKalori = kaloriPerGram * berat;
            textViewHasil.setText("Total Kalori: " + totalKalori);
        } else {
            Toast.makeText(this, "Data kalori tidak tersedia", Toast.LENGTH_SHORT).show();
        }
    }
}
