package com.example.finalproject1;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OrderTrackingActivity extends AppCompatActivity {

    ProgressBar orderProgress;
    TextView orderStatus, estimatedTime, orderId, orderSummary;
    int progress = 25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_tracking);

        orderProgress = findViewById(R.id.orderProgress);
        orderStatus = findViewById(R.id.orderStatus);
        estimatedTime = findViewById(R.id.estimatedTime);
        orderId = findViewById(R.id.orderId);
        orderSummary = findViewById(R.id.orderSummary);

        // Sample Order Data
        orderId.setText("Order ID: #12345");
        orderSummary.setText("1x Burger, 1x Fries, 1x Coke");

        simulateOrderProgress();
    }

    private void simulateOrderProgress() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            if (progress < 100) {
                progress += 25;
                orderProgress.setProgress(progress);

                switch (progress) {
                    case 50:
                        orderStatus.setText("Status: Out for Delivery");
                        estimatedTime.setText("Estimated delivery in 7 minutes");
                        break;
                    case 75:
                        orderStatus.setText("Status: Arriving Soon");
                        estimatedTime.setText("Estimated delivery in 3 minutes");
                        break;
                    case 100:
                        orderStatus.setText("Status: Delivered");
                        estimatedTime.setText("Delivered to classroom 3B");
                        break;
                }

                simulateOrderProgress(); // Repeat the update
            }
        }, 5000); // every 5 seconds
    }
}