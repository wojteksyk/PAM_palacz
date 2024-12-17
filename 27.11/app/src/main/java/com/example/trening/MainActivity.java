package com.example.trening;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn = findViewById(R.id.button);
        TextView output = findViewById(R.id.textView6);


        String REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

        btn.setOnClickListener(l -> {
            String email = ((EditText) findViewById(R.id.editTextTextEmailAddress)).getText().toString();
            String pass = ((EditText) findViewById(R.id.editTextTextPassword)).getText().toString();
            String passconf = ((EditText) findViewById(R.id.editTextTextPassword2)).getText().toString();


            if (!email.contains("@")) {
                output.setText("Nieprawidłowy email!");
            } else if (!pass.equals(passconf)) {
                output.setText("Hasła nie są zgodne!");
            }

            else if (!pass.matches(REGEX)) {
                output.setText("Hasło musi mieć co najmniej 8 znaków, jedną dużą literę, jedną małą literę i jedną cyfrę.");
            } else {
                Intent intent = new Intent(MainActivity.this, Welcome.class);
                intent.putExtra("dupa", email);
                startActivity(intent);
            }
        });
    }
}