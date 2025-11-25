package com.example.rgb;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int red_value;
    int blue_value;
    int green_value;
    TextView tv1;

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

        red_value = 0;
        blue_value = 0;
        green_value = 0;

        tv1 = findViewById(R.id.textView);

        SeekBar seekbar_red = findViewById(R.id.seekBar_red);
        SeekBar seekbar_blue = findViewById(R.id.seekBar_blue);
        SeekBar seekbar_green = findViewById(R.id.seekBar_green);

        TextView tv_red = findViewById(R.id.red);
        TextView tv_blue = findViewById(R.id.blue);
        TextView tv_green = findViewById(R.id.green);

        seekbar_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            red_value = progress;
            tv_red.setText(String.valueOf(progress));
            changeRect();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekbar_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue_value = progress;
                tv_blue.setText(String.valueOf(progress));
                changeRect();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekbar_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green_value = progress;
                tv_green.setText(String.valueOf(progress));
                changeRect();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(v->{

            TextView rect = findViewById(R.id.color1);
            rect.setText(red_value + "," + green_value + "," + blue_value);
            rect.setBackgroundColor(Color.rgb(red_value, green_value, blue_value));

        });
    }
    public void changeRect(){
        tv1.setBackgroundColor(Color.rgb(red_value, green_value, blue_value));
    }
}