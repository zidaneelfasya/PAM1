package com.example.projekpam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BerandaActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btncaloricounter;
    private TextView tvGreeting;
    private ImageView ivGuidance; // Tambahkan variabel untuk ImageView panduan

    private ImageView icExit,icInfo,icMotivation,icBeratIdeal; // Tambahkan variabel untuk ImageView exit

    private LinearLayout stepTracker, btnWorkoutHarian, btnWorkoutHiit, btnSenam; // Tambahkan variabel untuk LinearLayout pelacakan langkah

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda); // Pastikan layout sesuai dengan nama file Anda

        // Inisialisasi FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        btncaloricounter = findViewById(R.id.calorie_calculator_button);
        // Temukan TextView dengan ID greeting
        tvGreeting = findViewById(R.id.greeting);

        // Temukan ImageView dengan ID yang sesuai untuk panduan
        ivGuidance = findViewById(R.id.ic_guidance); // Pastikan ID sesuai dengan layout Anda

        // Temukan ImageView dengan ID ic_exit
        icExit = findViewById(R.id.ic_exit);
        icInfo = findViewById(R.id.ic_info);
        icMotivation = findViewById(R.id.ic_motivation);
        icBeratIdeal = findViewById(R.id.ic_berat_ideal);
        // Temukan LinearLayout dengan ID step_tracker
        stepTracker = findViewById(R.id.step_tracker);
        btnWorkoutHarian = findViewById(R.id.btn_workout_harian);
        btnWorkoutHiit = findViewById(R.id.btn_workout_hiit);
        btnSenam = findViewById(R.id.btn_senam);
        // Dapatkan pengguna saat ini
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            // Ambil email dari FirebaseUser dan setel pada TextView
            String email = currentUser.getEmail();
            if (email != null) {
                tvGreeting.setText("Halo, " + email);
            }
        } else {
            // Jika tidak ada pengguna yang login, tampilkan pesan dan arahkan ke LoginActivity
            Toast.makeText(BerandaActivity.this, "Tidak ada pengguna yang login", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(BerandaActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        // Atur onClickListener untuk ImageView panduan
        ivGuidance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arahkan ke MenuutamaActivity
                Intent intent = new Intent(BerandaActivity.this, MenuutamaActivity.class);
                startActivity(intent);
            }
        });
        icMotivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arahkan ke MenuutamaActivity
                Intent intent = new Intent(BerandaActivity.this, DukungMotivasiActivity.class);
                startActivity(intent);
            }
        });

        btncaloricounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arahkan ke CaloriCounterActivity
                Intent intent = new Intent(BerandaActivity.this, CaloriCounterActivity.class);
                startActivity(intent);
            }
        });
        icBeratIdeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arahkan ke CaloriCounterActivity
                Intent intent = new Intent(BerandaActivity.this, IMBActivity.class);
                startActivity(intent);
            }
        });

        // Atur onClickListener untuk ic_exit
        icExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect ke halaman login
                Intent intent = new Intent(BerandaActivity.this, LoginActivity.class);
                mAuth.signOut();
                startActivity(intent);
                finish(); // Tutup activity saat ini
            }
        });
        icInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect ke halaman login
                Intent intent = new Intent(BerandaActivity.this, WorkoutSelectionActivity.class);
                startActivity(intent);

            }
        });

        // Atur onClickListener untuk step_tracker
        stepTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arahkan ke StatsActivity
                Intent intent = new Intent(BerandaActivity.this, StatsActivity.class);
                startActivity(intent);
            }
        });
        btnWorkoutHarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arahkan ke StatsActivity
                Intent intent = new Intent(BerandaActivity.this, JadwalWorkoutActivity.class);
                startActivity(intent);
            }
        });
        btnWorkoutHiit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arahkan ke StatsActivity
                Intent intent = new Intent(BerandaActivity.this,WorkoutHiitActivity.class);
                startActivity(intent);
            }
        });btnSenam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arahkan ke StatsActivity
                Intent intent = new Intent(BerandaActivity.this,SenamActivity.class);
                startActivity(intent);
            }
        });

    }
}
