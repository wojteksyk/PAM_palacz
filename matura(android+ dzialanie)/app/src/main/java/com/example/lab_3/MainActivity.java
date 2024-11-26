package com.example.lab_3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        EditText confirmPassword = findViewById(R.id.confirmPassword);
        Button submit = findViewById(R.id.submit);
        TextView message = findViewById(R.id.message);

        submit.setOnClickListener(view -> {
            String emailText = email.getText().toString();
            String passwordText = password.getText().toString();
            String confirmPasswordText = confirmPassword.getText().toString();

            if (!emailText.contains("@")) {
                message.setText("Nieprawidłowy adres e-mail");
            } else if (!passwordText.equals(confirmPasswordText)) {
                message.setText("Hasła się różnią");
            } else {
                message.setText("Witaj " + emailText);
            }
        });
    }
}
