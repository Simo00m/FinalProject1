package com.example.finalproject1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Find all the food item layouts
        LinearLayout chickenBurgerItem = findViewById(R.id.chickenBurgerItem);
        LinearLayout jollofItem = findViewById(R.id.jollofItem);
        LinearLayout doughnutItem = findViewById(R.id.doughnutItem);
        LinearLayout biryaniItem = findViewById(R.id.biryaniItem);

        // Set onClick for Chicken Burger
        chickenBurgerItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, OrderUpdateActivity.class);
                startActivity(intent);
            }
        });

        // Set onClick for Jollof Rice
        jollofItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, OrderUpdateActivity.class);
                startActivity(intent);
            }
        });

        // Set onClick for Doughnut
        doughnutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, OrderUpdateActivity.class);
                startActivity(intent);
            }
        });

        // Set onClick for Biryani
        biryaniItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, OrderUpdateActivity.class);
                startActivity(intent);
            }
        });
    }
}
