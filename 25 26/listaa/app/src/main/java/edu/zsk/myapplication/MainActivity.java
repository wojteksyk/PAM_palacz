package edu.zsk.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final ArrayList<String> list = new ArrayList<>();

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
        list.add("Zakupy: chleb, masło, ser ");
        list.add("Do zrobienia: obiad, umyć podłogi");
        list.add("weekend: kino, spacer z psem ");

        ArrayAdapter<String> ArrayAdapter = new ArrayAdapter<>(this, R.layout.listt, R.id.new_list, list);

        ListView view1 = findViewById(R.id.listView);

        view1.setAdapter(ArrayAdapter);

        Button btn1 = findViewById(R.id.button);
        EditText editText1 = findViewById(R.id.editTextText);

        btn1.setOnClickListener(l -> {
            if (!editText1.getText().toString().isEmpty()) {
                list.add(editText1.getText().toString());

                ArrayAdapter.notifyDataSetChanged();
            }
        });
    }
}