package com.example.finalproject1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OrderUpdateActivity extends AppCompatActivity {

    private TextView deliveryTimeText, statusPreparing, statusOutForDelivery, statusDelivered;
    private Button updateStatusButton;
    private int orderStep = 0;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean statusCompleted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderupdate);

        deliveryTimeText = findViewById(R.id.delivery_time);
        statusPreparing = findViewById(R.id.status_preparing);
        statusOutForDelivery = findViewById(R.id.status_out_for_delivery);
        statusDelivered = findViewById(R.id.status_delivered);
        updateStatusButton = findViewById(R.id.btnUpdateStatus);

        deliveryTimeText.setText("10:15 AM");

        updateStatusButton.setOnClickListener(v -> {
            updateStatus();
            if (statusCompleted) {
                Intent intent = new Intent(OrderUpdateActivity.this, OrderTrackingActivity.class);
                startActivity(intent);
                finish();
            }
        });

        simulateOrderUpdates();

        // Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                Intent intent = new Intent(OrderUpdateActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
                return true;
            }
            return false;
        });
    }

    private void updateStatus() {
        if (!statusCompleted) {
            orderStep++;
            updateStatusView();
            if (orderStep >= 3) {
                statusCompleted = true;
                updateStatusButton.setEnabled(false);
            }
        }
    }

    private void simulateOrderUpdates() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!statusCompleted) {
                    orderStep++;
                    updateStatusView();
                    if (orderStep < 3) {
                        handler.postDelayed(this, 7000);
                    } else {
                        statusCompleted = true;
                        updateStatusButton.setEnabled(false);
                    }
                }
            }
        }, 7000);
    }

    private void updateStatusView() {
        switch (orderStep) {
            case 1:
                statusPreparing.setText("✓ Order being prepared");
                break;
            case 2:
                statusOutForDelivery.setText("✓ Out for delivery");
                break;
            case 3:
                statusDelivered.setText("✓ Delivered to classroom");
                break;
        }
    }
}
