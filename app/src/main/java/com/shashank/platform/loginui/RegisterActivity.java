package com.shashank.platform.loginui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout inputEmail, inputPassword, inputConPass, userName;
    private ProgressBar progressBar;
    private Button regButton;
    private TextView signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = findViewById(R.id.userName);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        inputConPass = findViewById(R.id.inputConPassword);
        regButton = findViewById(R.id.registerBtn);
        signIn = findViewById(R.id.signin);
        progressBar = findViewById(R.id.progressBar);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRegister();
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    private void doRegister() {
        progressBar.setVisibility(View.VISIBLE);
        final String email = inputEmail.getEditText().getText().toString().trim();
        final String password = inputPassword.getEditText().getText().toString().trim();
        final String conpassword = inputConPass.getEditText().getText().toString().trim();
        final String uNAme = userName.getEditText().getText().toString().trim();

        if (uNAme.isEmpty()) {
            progressBar.setVisibility(View.GONE);
            showError(userName, "Username cannot be empty");
        } else if (email.isEmpty()) {
            progressBar.setVisibility(View.GONE);
            showError(inputEmail, "Email is not valid");
        } else if (password.isEmpty() || password.length() < 4) {
            progressBar.setVisibility(View.GONE);
            showError(inputPassword, "Password must be greater than 4 letter");
        } else if (conpassword.isEmpty() || (!conpassword.equals(password))) {
            progressBar.setVisibility(View.GONE);
            showError(inputConPass, "Password did not match");
        } else {
            //Write your registration code here
            progressBar.setVisibility(View.GONE);
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
        }
    }

    private void showError(TextInputLayout eText, String text) {
        eText.setError(text);
        eText.requestFocus();
    }
}
