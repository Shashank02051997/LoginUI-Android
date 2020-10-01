package com.shashank.platform.loginui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout inputEmail, inputPass;
    private Button loginBtn;
    private TextView signUp, forgetPass;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.inputEmail);
        inputPass = findViewById(R.id.inputPassword);
        loginBtn = findViewById(R.id.loginBtn);
        signUp = findViewById(R.id.createAccount);
        forgetPass = findViewById(R.id.forget);
        progressBar = findViewById(R.id.progressBar);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });

        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });
    }

    private void doLogin() {
        progressBar.setVisibility(View.VISIBLE);
        String email = inputEmail.getEditText().getText().toString().trim();
        String password = inputPass.getEditText().getText().toString().trim();

        if (email.isEmpty()) {
            progressBar.setVisibility(View.GONE);
            showError(inputEmail, "Email is not valid");
        } else if (password.isEmpty() || password.length() < 4) {
            progressBar.setVisibility(View.GONE);
            showError(inputPass, "Password must be greater than 4 letter");
        } else {
            //Write your login code here
            progressBar.setVisibility(View.GONE);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }

    private void resetPassword() {
        //write your reset password code here
    }

    private void showError(TextInputLayout eText, String text) {
        eText.setError(text);
        eText.requestFocus();
    }
}
