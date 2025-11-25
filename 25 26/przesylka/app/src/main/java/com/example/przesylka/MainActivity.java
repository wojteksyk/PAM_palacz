package com.example.przesylka;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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
        EditText kod_pocztowy = findViewById(R.id.kod_pocztowy);
        Button btn = findViewById(R.id.button2);

        RadioGroup radio_gruop = findViewById(R.id.container_radio_group);
         Button btn_conf = findViewById(R.id.button);

         btn_conf.setOnClickListener(v->{

             ImageView imageView = findViewById(R.id.imageView);
             TextView tv_price = findViewById(R.id.textView);

             int SelectedID =  radio_gruop.getCheckedRadioButtonId();
             if (SelectedID == R.id.radio_pocztowka) {
                 tv_price.setText("Cena: 1zł");
                 imageView.setImageResource(R.drawable.pocztowka);
             } else if (SelectedID==R.id.radio_list) {
                 tv_price.setText("Cena: 1,5zł");
                 imageView.setImageResource(R.drawable.list);
             }
             else if (SelectedID==R.id.radio_paczka) {
                 tv_price.setText("Cena: 10zł");
                 imageView.setImageResource(R.drawable.paczka);
             }
             else{
                 AlertDialog.Builder builder  = new AlertDialog.Builder(this);
                 builder.setTitle("Alert");
                 builder.setMessage("musisz cos wybrac");
                 builder.setPositiveButton("OK", (dialog, which) -> {
                     dialog.dismiss();
                 });
                 builder.show();
             }

         });

        btn.setOnClickListener(v->{
            String pocztowy = kod_pocztowy.getText().toString();
            if(pocztowy.length() == 5){
                if(pocztowy.matches("[0-9]+")){


                AlertDialog.Builder builder  = new AlertDialog.Builder(this);
                builder.setTitle("Alert");
                builder.setMessage("Dane przesyłki zostały wprowadzone");
                builder.setPositiveButton("OK", (dialog, which) -> {
                    dialog.dismiss();
                });
                builder.show();
            }
            else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Alert");
                    builder.setMessage("Kod pocztowy powinien się składać z samych cyfr");
                    builder.setPositiveButton("OK", (dialog, which) -> {
                        dialog.dismiss();
                    });
                    builder.show();
                }

            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Alert");
                builder.setMessage("Nieprawidłowa liczba cyfr w kodzie pocztowym");
                builder.setPositiveButton("OK", (dialog, which) -> {
                    dialog.dismiss();
                });
                builder.show();
            }
        });

    }
}