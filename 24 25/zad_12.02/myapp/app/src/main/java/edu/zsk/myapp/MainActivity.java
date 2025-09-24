package edu.zsk.myapp;

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

    private EditText inputName, inputEmail;
    private TextView greetingText, clickCountText;
    private Button submitButton;
    private int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.inputName);
        inputEmail = findViewById(R.id.inputEmail);
        greetingText = findViewById(R.id.greetingText);
        clickCountText = findViewById(R.id.clickCountText);
        submitButton = findViewById(R.id.submitButton);

        if (savedInstanceState != null) {
            clickCount = savedInstanceState.getInt("clickCount");
            clickCountText.setText("Kliknąłeś przycisk " + clickCount + " razy");
            greetingText.setText(savedInstanceState.getString("greetingMessage", ""));
        }

        submitButton.setOnClickListener(v -> {
            String name = inputName.getText().toString().trim();
            String email = inputEmail.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(MainActivity.this, "Uzupełnij wszystkie dane", Toast.LENGTH_SHORT).show();
            } else {
                clickCount++;
                clickCountText.setText("Kliknąłeś przycisk " + clickCount + " razy");
                greetingText.setText("Witaj " + name + "! Twój adres email to: " + email);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("clickCount", clickCount);
        outState.putString("greetingMessage", greetingText.getText().toString());
    }
}
