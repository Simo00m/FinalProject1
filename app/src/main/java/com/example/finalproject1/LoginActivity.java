package com.example.finalproject1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText emailInput;
    EditText passwordInput;

    // Placeholders for testing
    String approvedEmail = "email@mybvc.ca";
    String approvedPassword = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        emailInput = findViewById(R.id.editTxt_email);
        passwordInput = findViewById(R.id.editTxt_password);
    }

    public void login(View view){
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        TextView error = findViewById(R.id.txtView_loginError);

        if(email.equals(approvedEmail) && password.equals(approvedPassword)){
            //Intent intent = new Intent(this, HomePage.class);
            //activityResultLauncher.launch(intent);
        }
        else{
            error.setVisibility(View.VISIBLE);
        }
    }
}
