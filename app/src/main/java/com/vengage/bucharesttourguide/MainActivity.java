package com.vengage.bucharesttourguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // The ViewPager that allows swiping list left and right
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // The fragments adapter
        ListTypeAdapter listTypeAdapter = new ListTypeAdapter(getSupportFragmentManager(), MainActivity.this);

        // Set adapter to the ViewPager
        viewPager.setAdapter(listTypeAdapter);

        // Set the TabLayout to the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
