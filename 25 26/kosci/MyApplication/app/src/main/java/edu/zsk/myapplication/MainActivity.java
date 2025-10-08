package edu.zsk.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {



    private ArrayList<Integer> kosci = new ArrayList<>();
    private int total = 0;

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

        Button rollBtn = findViewById(R.id.rollBtn);
        Button resetBtn = findViewById(R.id.resetBtn);
        TextView current = findViewById(R.id.current);
        TextView totalscore = findViewById(R.id.total);

        ArrayList<ImageView> diceImages = new ArrayList<>();
        diceImages.add(findViewById(R.id.kosci1));
        diceImages.add(findViewById(R.id.kosci2));
        diceImages.add(findViewById(R.id.kosci3));
        diceImages.add(findViewById(R.id.kosci4));
        diceImages.add(findViewById(R.id.kosci5));

        rollBtn.setOnClickListener(v -> {
            kosci.clear();
            for (int i = 0; i < 5; i++) {
                int value = random();
                kosci.add(value);
                int resId;
                switch (value) {
                    case 1: resId = R.drawable.k1; break;
                    case 2: resId = R.drawable.k2; break;
                    case 3: resId = R.drawable.k3; break;
                    case 4: resId = R.drawable.k4; break;
                    case 5: resId = R.drawable.k5; break;
                    case 6: resId = R.drawable.k6; break;
                    default: resId = R.drawable.question;
                }
                diceImages.get(i).setImageResource(resId);
            }
            int rollScore = calc();
            total += rollScore;
            current.setText(getString(R.string.wynik) + " " + rollScore);
            totalscore.setText(getString(R.string.game_res) + " " + total);
        });

        resetBtn.setOnClickListener(v -> {
            kosci.clear();
            total = 0;
            for (int i = 0; i < 5; i++) {
                diceImages.get(i).setImageResource(R.drawable.question);
            }
            current.setText(getString(R.string.wynik) + " 0");
            totalscore.setText(getString(R.string.game_res) + " 0");
        });
    }

    private int random() {
        return new Random().nextInt(6) + 1;
    }

    private int calc() {
        int sum = 0;
        for (int val : kosci) sum += val;
        return sum;
    }
}
