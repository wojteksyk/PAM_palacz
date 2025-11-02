package edu.zsk.weterynarz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] tab = {"pies","kot","Świnka Morska"};

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


        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.list_element, R.id.lista_1, tab);
        listView.setAdapter(arrayAdapter);


        SeekBar seekBar1 = findViewById(R.id.seekBar);

        String[] chosen = {tab[0]};
        int[] wiek = {0};

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int
                    myItemInt, long mylng) {
                chosen[0] = (String) listView.getItemAtPosition(myItemInt);

                switch (myItemInt){
                    case 0:
                        seekBar1.setMax(18);
                        break;
                    case 1:
                        seekBar1.setMax(20);
                        break;
                    case 2:
                        seekBar1.setMax(9);
                        break;
                }
            }
        });


        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean
                    fromUser) {
                TextView age1 = findViewById(R.id.age1);
                wiek[0] = progress;
                age1.setText(String.valueOf(wiek[0]));
            }
        });

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(v -> {

            EditText name = findViewById(R.id.editTextText);
            TextView gatunek = findViewById(R.id.textView2);
            TextView cel = findViewById(R.id.editTextText2);
            TextView godzina = findViewById(R.id.editTextTime);

            String msg = "Imie i nazwisko: "+ name.getText().toString()
                    +", Gatunek: " + chosen[0]
                    +", Wiek: " + wiek[0]
                    + " ,Cel wizyty: "
                    + cel.getText().toString()
                    + ", godzina:  " + godzina.getText().toString();

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Wizyta u weterynarza: ");
            builder.setMessage(msg);
            builder.setPositiveButton("zamknij", (dialog, which) -> dialog.dismiss());
            builder.show();
        });







    }
}