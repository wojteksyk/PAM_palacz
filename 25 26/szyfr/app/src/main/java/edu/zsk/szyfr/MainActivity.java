package edu.zsk.szyfr;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        Button btn2 = findViewById(R.id.btn2);
        Button btn1 = findViewById(R.id.btn1);
        EditText text1 = findViewById(R.id.text1);
        EditText key = findViewById(R.id.editTextText);

        TextView szyfr = findViewById(R.id.szyfr);

        btn1.setOnClickListener(v ->{
            Integer key_int = Integer.parseInt(key.getText().toString());
            String text1_string = text1.getText().toString();
            if (key_int == null) {
                Toast.makeText(this, "Podaj klucz!", Toast.LENGTH_SHORT).show();
                return;
            }
            StringBuilder wynik = new StringBuilder();

            for(char c : text1_string.toCharArray()){
                if(Character.isUpperCase(c)){
                    char encryptedChar = (char) ('A' + (c - 'A' + key_int)% 26);
                    wynik.append(encryptedChar);
                }
                    else if(Character.isLowerCase(c)){
                        char encryptedChar = (char) ('a' + (c - 'a' + key_int)% 26);
                        wynik.append(encryptedChar);
                    }
                    else{
                        wynik.append(c);
                    }
            }
szyfr.setText(wynik.toString());
        });
        btn2.setOnClickListener(v -> {
Toast.makeText(this, "Nie da sie", Toast.LENGTH_SHORT).show();
        });

    }
}