package com.example.finalproject1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ScrollView menuScrollView = findViewById(R.id.menuScrollView);
        // Find all the food item layouts
        LinearLayout chickenBurgerItem = findViewById(R.id.chickenBurgerItem);
        LinearLayout jollofItem = findViewById(R.id.jollofItem);
        LinearLayout doughnutItem = findViewById(R.id.doughnutItem);
        LinearLayout biryaniItem = findViewById(R.id.biryaniItem);

        // Find Buttons
        Button allButton = findViewById(R.id.allButton);
        Button burgerButton = findViewById(R.id.burgerButton);
        Button riceButton = findViewById(R.id.riceButton);
        Button doughnutButton = findViewById(R.id.doughnutButton);

// All Button - Scroll to Top
        allButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuScrollView.smoothScrollTo(0, 0); // Scroll to top
            }
        });

// Burger Button - Scroll to Chicken Burger
        burgerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuScrollView.smoothScrollTo(0, chickenBurgerItem.getTop());
            }
        });

// Rice Button - Scroll to Biryani
        riceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuScrollView.smoothScrollTo(0, biryaniItem.getTop());
            }
        });

// Doughnut Button - Scroll to Doughnut
        doughnutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuScrollView.smoothScrollTo(0, doughnutItem.getTop());
            }
        });

        View.OnClickListener openOrderUpdateListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open OrderUpdateActivity WITHOUT passing extras
                Intent intent = new Intent(MenuActivity.this, OrderUpdateActivity.class);
                startActivity(intent);
            }
        };

        // Assign the same click listener to all items
        chickenBurgerItem.setOnClickListener(openOrderUpdateListener);
        jollofItem.setOnClickListener(openOrderUpdateListener);
        doughnutItem.setOnClickListener(openOrderUpdateListener);
        biryaniItem.setOnClickListener(openOrderUpdateListener);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                finish(); // Optional but good: closes the current page
                return true;
            }
            return false;
        });


    }
}
