package com.example.showhideelement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean showText;
    private boolean enableHideButton;
    private boolean enableShowButton;
    private Button hideButton;
    private Button showButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showText = false;
        enableHideButton = false;
        enableShowButton = true;
        hideButton = findViewById(R.id.button2);
        showButton = findViewById(R.id.button);
        hideButton.setEnabled(showText);
        showButton.setEnabled(!showText);
    }

    public void textEnableDisable(View view){
        TextView textView = findViewById(R.id.textView);

            if(!showText){
                textView.setVisibility(View.VISIBLE);
            }
            else{
                textView.setVisibility(View.INVISIBLE);
            }

            showText = !showText;
        hideButton.setEnabled(showText);
        showButton.setEnabled(!showText);
    }
}
