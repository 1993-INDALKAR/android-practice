package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> answers = new ArrayList<>();
    int locationOfCorrectAnswer;
    int numOfQuestions = 0;
    int score = 0;
    TextView questionTextView;
    TextView scoreTextview;
    TextView timerTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         questionTextView = findViewById(R.id.textView3);
         button0 = findViewById(R.id.button0);
         button1 = findViewById(R.id.button1);
         button2 = findViewById(R.id.button2);
         button3 = findViewById(R.id.button3);
         scoreTextview = findViewById(R.id.scoreTextView);
        timerTextView  = findViewById(R.id.textView);
         newQuestion();
    }




    public void startGame(View view){
        Button goBtn = findViewById(R.id.goButton);
        goBtn.setVisibility(View.INVISIBLE);


    }

    public void chooseAnswer(View view){
           if(Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())){
               Toast.makeText(this,"Correct!!!",Toast.LENGTH_SHORT);
               score++;
           }
           else{
               Toast.makeText(this,"Correct!!!",Toast.LENGTH_SHORT);
        }
           numOfQuestions++;
           scoreTextview.setText(Integer.toString(score)+"/"+Integer.toString(numOfQuestions));

        newQuestion();

        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {

            }
        }.start();

    }


    public void newQuestion(){

        Random ran = new Random();
        scoreTextview = findViewById(R.id.scoreTextView);

        int x = ran.nextInt(21);
        int y = ran.nextInt(21);

        int sum = x + y;
        String question = Integer.toString(x)+"+"+Integer.toString(y);
        questionTextView.setText(question);
        locationOfCorrectAnswer = ran.nextInt(4);

        answers.clear();

        for (int i =0;i<4;i++){
            if(i==locationOfCorrectAnswer){
                answers.add(x+y);
            }
            else{
                int wrongAnswer = ran.nextInt(21)+ran.nextInt(21);

                while(wrongAnswer == x+y){
                    wrongAnswer = ran.nextInt(21)+ran.nextInt(21);
                }
                answers.add(wrongAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));


    }
}
