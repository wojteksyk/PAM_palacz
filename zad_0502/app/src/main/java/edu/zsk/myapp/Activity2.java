package edu.zsk.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // Długi tekst na ekranie
        TextView textView = findViewById(R.id.textView);
        textView.setText("To jest długi tekst, który wyświetla się w drugiej aktywności. Możesz tutaj wprowadzić dowolną treść.");

        Button btn3 = findViewById(R.id.button3);

        // Przycisk do powrotu do MainActivity
        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(Activity2.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
