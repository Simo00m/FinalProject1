package com.example.finalproject1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmOrderActivity extends AppCompatActivity {

    private TextView tvConfirmationMessage;
    private Button btnConfirmOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_order);

        tvConfirmationMessage = findViewById(R.id.tvConfirmationMessage);
        btnConfirmOrder = findViewById(R.id.btnConfirmOrder);

        // Get data from intent
        String paymentMethod = getIntent().getStringExtra("payment_method");
        String totalAmount = getIntent().getStringExtra("TOTAL_AMOUNT");
        String deliverySlot = getIntent().getStringExtra("DELIVERY_SLOT");

        // Set confirmation message
        String message = "Thank you for your order!\n\n"
                + "Payment Method: " + "MasterCard" + "\n"
                + "Total Amount: " + "$25" + "\n"
                + "Delivery Slot: " + "Fast Delivery";

        tvConfirmationMessage.setText(message);

        // Confirm Order Button click
        btnConfirmOrder.setOnClickListener(v -> {
            Intent intent = new Intent(ConfirmOrderActivity.this, PaymentActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
