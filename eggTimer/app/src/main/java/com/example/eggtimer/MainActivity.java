package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private SeekBar seekBar;

    public void buttonClicked(View view){
        CountDownTimer countDownTimer = new CountDownTimer(seekBar.getProgress()*1000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int) (millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public void updateTimer(int progress){
        int minutes = progress/60;
        int seconds = progress - (minutes*60);

        String secondsStr = ""+seconds;
        if(seconds<10 && seconds!=0){
            secondsStr = "0"+seconds;
        }
        else if(seconds==0){
            secondsStr = "00";
        }

        String minutesStr = ""+minutes;
        if(minutes<10 && minutes!=0){
            minutesStr = "0"+minutes;
        }
        else if(minutes==0){
            minutesStr = "00";
        }

        textView = findViewById(R.id.textId);
        textView.setText(minutesStr+":"+secondsStr);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         seekBar = findViewById(R.id.seekBar);
        ImageView imageView = findViewById(R.id.imageView);

        seekBar.setMax(600);
        seekBar.setProgress(30);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                updateTimer(progress);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
