package com.example.finalproject1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    private Button btnAddPayment;
    private Button btnPlaceOrder;
    private RadioGroup paymentMethodGroup;
    private RadioButton radioCreditCard, radioPayPal, radioGooglePay, radioMastercard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // Initialize views
        initializeViews();
        radioMastercard.setChecked(true);

        setupClickListeners();
    }

    private void initializeViews() {
        btnAddPayment = findViewById(R.id.btnAddPayment);
        btnPlaceOrder = findViewById(R.id.btnPlaceOrder);
        paymentMethodGroup = findViewById(R.id.paymentMethodGroup);
        radioCreditCard = findViewById(R.id.radioCreditCard);
        radioPayPal = findViewById(R.id.radioPayPal);
        radioGooglePay = findViewById(R.id.radioGooglePay);
        radioMastercard = findViewById(R.id.radioMastercard);
    }

    private void setupClickListeners() {
        btnAddPayment.setOnClickListener(v -> showAddPaymentDialog());

        btnPlaceOrder.setOnClickListener(v -> processOrder());
    }

    private void showAddPaymentDialog() {
        Toast.makeText(this, "Add payment method functionality would go here", Toast.LENGTH_SHORT).show();
    }

    private void processOrder() {
        String paymentMethod = getSelectedPaymentMethod();

        if (paymentMethod.isEmpty()) {
            Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean paymentSuccess = processPayment(paymentMethod);

        if (paymentSuccess) {
            navigateToOrderUpdate();
        } else {
            Toast.makeText(this, "Payment failed. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }

    private String getSelectedPaymentMethod() {
        int selectedId = paymentMethodGroup.getCheckedRadioButtonId();
        if (selectedId == R.id.radioCreditCard) {
            return "Credit Card";
        } else if (selectedId == R.id.radioPayPal) {
            return "PayPal";
        } else if (selectedId == R.id.radioGooglePay) {
            return "Google Pay";
        } else if (selectedId == R.id.radioMastercard) {
            return "Mastercard ****0000";
        }
        return "";
    }

    private boolean processPayment(String paymentMethod) {
        return true; // simulate success
    }

    private void navigateToOrderUpdate() {
        Intent intent = new Intent(this, OrderUpdateActivity.class);
        startActivity(intent);
        finish();
    }
}
