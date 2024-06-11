package com.example.projekpam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int[] layouts = {
            R.layout.onboarding_page1,
            R.layout.onboarding_page2,
            R.layout.onboarding_page3
    };
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inisialisasi FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        // Cek apakah user sudah login
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // Jika user sudah login, langsung ke BerandaActivity
            Intent intent = new Intent(MainActivity.this, BerandaActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        OnboardingPagerAdapter adapter = new OnboardingPagerAdapter(this, layouts);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == layouts.length - 1) {
                    View lastPage = viewPager.findViewWithTag("page:" + position);
                    if (lastPage != null) {
                        Button buttonLifestep = lastPage.findViewById(R.id.button_lifestep);
                        if (buttonLifestep != null) {
                            buttonLifestep.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
