package com.example.projekpam;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int[] layouts = {
            R.layout.onboarding_page1,
            R.layout.onboarding_page2,
            R.layout.onboarding_page3
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        OnboardingPagerAdapter adapter = new OnboardingPagerAdapter(this, layouts);
        viewPager.setAdapter(adapter);
    }
}
