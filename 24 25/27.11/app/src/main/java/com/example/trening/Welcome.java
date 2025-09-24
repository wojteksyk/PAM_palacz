package com.example.trening;


import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String email = getIntent().getStringExtra("dupa");
        TextView tekst = findViewById(R.id.welcome);
        Button btn1 = findViewById(R.id.button2);
btn1.setOnClickListener( v-> {
    Intent intent = new Intent(Welcome.this, MainActivity.class);
    startActivity(intent);
});

        tekst.setText("Witaj " + email);




    }
}